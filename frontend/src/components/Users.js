import React from "react";
import UserInfo from "./UserInfo";
import axios from "axios";
import { useState, useEffect } from "react";

const Users = () => {
  const [users, setUsers] = useState([]);
  const [storedUser, setStoredUser] = useState({});
  useEffect(() => {
    if (sessionStorage.getItem) {
      setStoredUser(JSON.parse(sessionStorage.getItem("userInfo")));
    }

    axios
      .get("http://localhost:8080/api/userInfo/all")
      .then((res) => {
        setUsers(res.data.data);
      })
      .catch((err) => console.error(err));
  }, []);
  return (
    <div className="py-5 px-16 grid grid-cols-3 gap-5 ">
      {users.map((user, id) => {
        return (
          <UserInfo
            name={user.name}
            userSectors={user.selectedSectors}
            key={id}
            userId={user.userId}
            storedUserId={
              storedUser && storedUser.userId ? storedUser.userId : ""
            }
          />
        );
      })}
    </div>
  );
};

export default Users;
