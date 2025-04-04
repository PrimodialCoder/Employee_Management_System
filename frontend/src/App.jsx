import "./App.css";
import ListEmployee from "./components/ListEmployee";
import Header from "./components/Header";
import Footer from "./components/Footer";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import CreateEmployee from "./components/CreateEmployee";

function App() {
  return (
    <>
      <BrowserRouter>
        <Header></Header>
        <Routes>
          {/* // http://localhost:3000 */}
          <Route path="/" element={<ListEmployee></ListEmployee>}></Route>
          {/* //http://localhost:3000/employees */}
          <Route path="/employees" element={<ListEmployee />}></Route>
          {/* //http://localhost:3000/add-employee */}
          <Route path="/add-employee" element={<CreateEmployee />}></Route>
        </Routes>

        <Footer></Footer>
      </BrowserRouter>
    </>
  );
}

export default App;
