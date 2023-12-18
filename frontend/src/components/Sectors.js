import React, { useEffect, useState } from "react";
import axios from "axios";
import { BASE_URL, organizeData } from "../utils/helpers";

const Sectors = ({ handleSelectInput, selectedSectors }) => {
  const [data, setData] = useState([]);
  const organizedData = organizeData(data);
  const [status, setStatus] = useState("loading");

  useEffect(() => {
    if (localStorage.getItem("sectors")) {
      setStatus("success");
      setData(JSON.parse(localStorage.getItem("sectors")));
    } else {
      axios
        .get(BASE_URL + "/sectors")
        .then((response) => {
          if (response.status === 200) {
            setData(response.data.data);
            localStorage.setItem("sectors", JSON.stringify(response.data.data));
            setStatus("success");
          }
        })
        .catch((err) => {
          setStatus("fail");
          console.error("Error fetching sectors: " + err);
        });
    }
  }, []);

  return (
    <div className="flex flex-col items-start w-full gap-1 ">
      <label
        htmlFor="selectedSectors"
        className="text-slate-100 text-md md:text-lgfont-semibold"
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
        {status === "success" ? (
          organizedData.map((sector, id) => {
            return (
              <optgroup key={id}>
                <option
                  id={sector[1].value.sectorId}
                  value={sector[1].value.sectorId}
                  className="md:text-base text-sm"
                >
                  {sector[0]}
                </option>
                {Object.entries(sector[1].subCategories).map((subSect, id) => {
                  return (
                    <>
                      <option
                        className="pl-3 md:text-base text-sm"
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
                                className="pl-6 md:text-base text-sm"
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
                                      className="pl-9 md:text-base text-sm"
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
          })
        ) : (
          <></>
        )}

        {status === "loading" ? (
          <option className="h-full p-auto flex items-center justify-center">
            loading...
          </option>
        ) : (
          <></>
        )}
        {status === "fail" ? (
          <option className="h-full p-auto flex items-center justify-center">
            failed to fetch all sectors.
          </option>
        ) : (
          <></>
        )}
      </select>
    </div>
  );
};

export default Sectors;
