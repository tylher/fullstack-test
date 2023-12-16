import React, { useEffect, useState } from "react";
import Sectors from "./Sectors";
import axios from "axios";
import { useLocation, useNavigate } from "react-router-dom";

const Form = () => {
  const [formData, setFormData] = useState({});
  const [edit, setEdit] = useState(false);
  const navigate = useNavigate();
  const location = useLocation();
  const searchParams = new URLSearchParams(location.search);

  useEffect(() => {
    setEdit(searchParams.get("edit"));
    if (sessionStorage.getItem("userInput")) {
      let savedUserInput = JSON.parse(sessionStorage.getItem("userInput"));
      setFormData(savedUserInput);
    }
  }, []);

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

  const handleSubmit = (e) => {
    e.preventDefault();
    if (formData.agreeToTerms === true) {
      return axios
        .post("http://localhost:8080/api/userInfo", formData)
        .then((res) => {
          sessionStorage.setItem("userInfo", JSON.stringify(res.data.data));
          sessionStorage.setItem("userInput", JSON.stringify(formData));
          navigate("/users");
        })
        .catch((ex) => {
          console.error(ex);
        });
    } else {
      console.error("please agree to terms before continuing");
    }
  };

  return (
    <div className="flex flex-col h-screen justify-center items-center">
      <form
        className="w-2/4 flex px-10 flex-col gap-3 bg-emerald-600 pt-7 pb-10 rounded-lg item-start"
        onSubmit={handleSubmit}
      >
        <h2 className="text-white text-[17px]">
          Please enter your name and pick the Sectors you are currently involved
          in.
        </h2>
        <div className="flex flex-col items-start w-full gap-1">
          <label
            htmlFor="name"
            className="text-slate-100 text-lg font-semibold"
          >
            Name:
          </label>
          <input
            type="text"
            id="name"
            name="name"
            className="w-full bg-gray-200 p-2 focus:bg-white rounded"
            onChange={handleInput}
            value={formData.name}
            required
          />
        </div>
        <Sectors
          handleSelectInput={handleInput}
          selectedSectors={formData.selectedSectors}
        />
        <div className="flex items-center w-full gap-1 ">
          <input
            id="agreeToTerms"
            name="agreeToTerms"
            type="checkbox"
            onChange={handleInput}
            className="h-5 w-5 text-blue-600 bg-gray-100 border-gray-300 rounded focus:ring-blue-500"
          />
          <label
            htmlFor="agreeToTerms"
            className="text-slate-100 text-lg font-semibold "
            checked={formData.agreeToTerms}
          >
            {" "}
            Agree To Terms
          </label>
        </div>

        <input
          type="submit"
          value="Save"
          className="bg-amber-300 text-gray-700 font-semibold w-fit text-lg px-2 rounded text-center py-1 leading-none"
        />
      </form>
    </div>
  );
};

export default Form;
