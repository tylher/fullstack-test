import {
  Navigate,
  Route,
  RouterProvider,
  createBrowserRouter,
  createRoutesFromElements,
} from "react-router-dom";
import "./App.css";
import Form from "./components/Form";
import UserInfo from "./components/UserInfo";
import Users from "./components/Users";

function App() {
  const router = createBrowserRouter(
    createRoutesFromElements(
      <Route>
        <Route path="/" element={<Navigate to={"/register"} />}></Route>
        <Route path="/register" element={<Form />}></Route>
        <Route path="/users" element={<Users />}></Route>
      </Route>
    )
  );

  return <RouterProvider router={router}></RouterProvider>;
}

export default App;
