import React, { useEffect, useState } from "react";
import Sectors from "./Sectors";
import axios from "axios";
import { useLocation, useNavigate } from "react-router-dom";
import { BASE_URL, storeSession } from "../utils/helpers";
import { MoonLoader } from "react-spinners";

const Form = () => {
  const location = useLocation();
  const searchParams = new URLSearchParams(location.search);
  const urlParam = searchParams.get("edit");
  const [formData, setFormData] = useState({});
  const [errors, setErrors] = useState({});
  const [edit, setEdit] = useState(false);
  const [isLoading, setIsLoading] = useState(false);
  const navigate = useNavigate();

  useEffect(() => {
    if (sessionStorage.getItem("userInput")) {
      let savedUserInput = JSON.parse(sessionStorage.getItem("userInput"));
      setFormData(savedUserInput);
    }
  }, []);
  useEffect(() => {
    setEdit(urlParam);
  }, [edit, urlParam]);

  const handleInput = (e) => {
    const { name, value, options, checked, type } = e.target;
    if (type === "select-multiple") {
      const selectedOptions = Array.from(options)
        .filter((option) => option.selected)
        .map((option) => option.value);
      setFormData((prev) => {
        return { ...prev, [name]: selectedOptions };
      });
    } else if (type === "checkbox") {
      setFormData((prev) => {
        return { ...prev, [name]: checked };
      });
    } else {
      setFormData((prev) => {
        return { ...prev, [name]: value };
      });
    }
  };

  const updateErrors = (name, errorMessage) => {
    setErrors((prev) => {
      return {
        ...prev,
        [name]: errorMessage,
      };
    });
    setTimeout(() => {
      setErrors((prev) => {
        return {
          ...prev,
          [name]: null,
        };
      });
    }, 2000);
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    if (formData.agreeToTerms) {
      setIsLoading(true);
      if (edit) {
        const userId = JSON.parse(sessionStorage.getItem("userInfo")).userId;
        return await axios
          .put(BASE_URL + "/userInfo/" + userId, formData)
          .then((res) => {
            setIsLoading(false);
            navigate("/users");
            storeSession(res.data.data, formData);
          })
          .catch((ex) => {
            setIsLoading(false);
            updateErrors("form", ex.message);
          });
      } else {
        return await axios
          .post(BASE_URL + "/userInfo", formData)
          .then((res) => {
            setIsLoading(false);
            navigate("/users");
            storeSession(res.data.data, formData);
          })
          .catch((ex) => {
            setIsLoading(false);
            updateErrors("form", ex.message);
          });
      }
    } else {
      updateErrors("agreeToTerms", "please agree to terms before continuing");
    }
  };

  return (
    <div className="flex flex-col h-screen justify-center items-center">
      <form
        className=" md:3/4 lg:w-2/4 flex px-10 flex-col gap-3 bg-emerald-600 pt-7 pb-10 rounded-lg item-start mx-10"
        onSubmit={handleSubmit}
      >
        {errors["form"] ? (
          <span className="bg-red-500 text-white p-2 rounded leading-none">
            {errors["form"]}
          </span>
        ) : (
          <></>
        )}
        <h2 className="text-white text-[15px] md:text-[17px]">
          Please enter your name and pick the Sectors you are currently involved
          in.
        </h2>
        <div className="flex flex-col items-start w-full gap-1">
          <label
            htmlFor="name"
            className="text-slate-100 text-md md:text-lg font-semibold"
          >
            Name:
          </label>
          <input
            type="text"
            id="name"
            name="name"
            className="w-full bg-gray-200 p-2 md:text-base text-sm focus:bg-white rounded"
            onChange={handleInput}
            value={formData.name}
            required
          />
        </div>
        <Sectors
          handleSelectInput={handleInput}
          selectedSectors={formData.selectedSectors}
        />
        <div className="flex flex-col gap-2">
          {errors["agreeToTerms"] ? (
            <span className="bg-red-500 text-white p-2 rounded leading-none">
              {errors["agreeToTerms"]}
            </span>
          ) : (
            <></>
          )}
          <div className="flex items-center w-full gap-1 relative">
            <input
              id="agreeToTerms"
              name="agreeToTerms"
              type="checkbox"
              checked={formData.agreeToTerms}
              onChange={handleInput}
              className="h-5 w-5 text-blue-600 bg-gray-100 border-gray-300 rounded focus:ring-blue-500"
            />

            <label
              htmlFor="agreeToTerms"
              className="text-slate-100 text-md md:text-lg font-semibold "
            >
              {" "}
              Agree To Terms
            </label>
          </div>
        </div>

        <div className="flex gap-5">
          <input
            type="submit"
            value="Save"
            className="bg-amber-300 text-gray-700 font-semibold w-fit text-md md:text-lg px-2 rounded text-center py-1 leading-none hover:bg-amber-500 hover:text-white cursor-pointer"
          />
          {isLoading ? (
            <div>
              <MoonLoader size={25} />
            </div>
          ) : (
            <></>
          )}
        </div>
      </form>
    </div>
  );
};

export default Form;
