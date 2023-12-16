import React from "react";

const UserInfo = ({ name, userSectors, storedUserId, userId }) => {
  const handleClick = () => {};
  return (
    <div className="flex flex-col bg-lime-50 px-5 pt-3 pb-5 rounded gap-3">
      <h2 className="text-lg text-gray-800 font-semibold">{name}</h2>
      <div className="flex gap-3 flex-wrap">
        {userSectors.map((userSector, id) => {
          return (
            <span
              key={id}
              className="text-xs bg-white border-lime-400 border-[2px] rounded-md p-2"
            >
              {userSector.sector.name}
            </span>
          );
        })}
      </div>
      {userId === storedUserId ? (
        <button onClick={handleClick}>edit info</button>
      ) : (
        <></>
      )}
    </div>
  );
};

export default UserInfo;
