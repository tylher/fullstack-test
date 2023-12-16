import React, { useEffect, useState } from "react";
import axios from "axios";
import { BASE_URL, organizeData } from "../utils/helpers";

const Sectors = ({ handleSelectInput, selectedSectors }) => {
  const [data, setData] = useState([]);
  const organizedData = organizeData(data);

  useEffect(() => {
    if (localStorage.getItem("sectors")) {
      setData(JSON.parse(localStorage.getItem("sectors")));
    } else {
      axios
        .get(BASE_URL + "/sectors")
        .then((response) => {
          setData(response.data.data);
          localStorage.setItem("sectors", JSON.stringify(response.data.data));
        })
        .catch((err) => {
          console.error("Error fetching sectors: " + err);
        });
    }
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
