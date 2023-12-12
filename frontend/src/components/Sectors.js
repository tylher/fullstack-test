import React from "react";

const Sectors = ({ handleSelectInput }) => {
  return (
    <div className="flex flex-col items-start w-full gap-1 ">
      <label htmlFor="sectors" className="text-slate-100 text-lg font-semibold">
        Sectors:
      </label>
      <select
        name="sectors"
        multiple
        className="w-full bg-gray-200 focus:bg-white rounded-md focus:border-none focus:ring-transparent "
        onChange={handleSelectInput}
      >
        <option value={1}>manufacturing</option>
        <option value={2}>Science</option>
      </select>
    </div>
  );
};

export default Sectors;
