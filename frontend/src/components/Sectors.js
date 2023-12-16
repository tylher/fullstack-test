import React, { useEffect, useState } from "react";
import axios from "axios";

const Sectors = ({ handleSelectInput, selectedSectors }) => {
  const [data, setData] = useState([]);
  const organizedData = Object.entries(
    data.reduce((result, item) => {
      const category = item.category;
      const subcategory = item.subCategory;
      const parentSector = item.parentSector;
      if (!result[category.name]) {
        result[category.name] = { subCategories: {} };
      }
      if (subcategory !== null) {
        if (!result[category.name].subCategories[subcategory.name]) {
          result[category.name].subCategories[subcategory.name] = {};
        }
        if (parentSector) {
          if (
            !result[category.name].subCategories[subcategory.name][
              parentSector.name
            ]
          ) {
            result[category.name].subCategories[subcategory.name][
              parentSector.name
            ] = [];
          }
          result[category.name].subCategories[subcategory.name][
            parentSector.name
          ].push(item);
        } else {
          result[category.name].subCategories[subcategory.name].value = item;
        }
      } else {
        result[category.name].value = item;
      }

      return result;
    }, {})
  );

  useEffect(() => {
    axios
      .get("http://localhost:8080/api/sectors")
      .then((response) => {
        setData(response.data.data);
      })
      .catch((err) => {
        console.error("Error fetching sectors: " + err);
      });
  }, []);
  return (
    <div className="flex flex-col items-start w-full gap-1 ">
      <label
        htmlFor="selectedSectors"
        className="text-slate-100 text-lg font-semibold"
      >
        Sectors:
      </label>
      <select
        name="selectedSectors"
        id="selectedSectors"
        multiple
        className="w-full bg-gray-200 focus:bg-white rounded-md focus:border-none focus:ring-transparent "
        onChange={handleSelectInput}
        value={selectedSectors}
        required
      >
        {organizedData.map((sector, id) => {
          return (
            <optgroup key={id}>
              <option
                id={sector[1].value.sectorId}
                value={sector[1].value.sectorId}
              >
                {sector[0]}
              </option>
              {Object.entries(sector[1].subCategories).map((subSect, id) => {
                return (
                  <>
                    <option
                      className="pl-3"
                      id={subSect[1].value.sectorId}
                      value={subSect[1].value.sectorId}
                    >
                      {subSect[0]}
                    </option>
                    {Object.entries(subSect[1]).map((childSect, id) => {
                      if (childSect[0] !== "value") {
                        return (
                          <>
                            <option
                              className="pl-6"
                              id={childSect[1][0].sectorId}
                              value={childSect[1][0].sectorId}
                            >
                              {childSect[0]}
                            </option>
                            {childSect[1].map((sect, id) => {
                              if (sect.name !== childSect[0]) {
                                return (
                                  <option
                                    id={sect.sectorId}
                                    value={sect.sectorId}
                                    key={id}
                                    className="pl-9"
                                  >
                                    {sect.name}
                                  </option>
                                );
                              }
                            })}
                          </>
                        );
                      }
                    })}
                  </>
                );
              })}
            </optgroup>
          );
        })}
      </select>
    </div>
  );
};

export default Sectors;
