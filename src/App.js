import "./App.css";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import FooterComponents from "./components/FooterComponents";
import HeaderComponents from "./components/HeaderComponents";
import { ListEmployeeComponents } from "./components/ListEmployeeComponents";
import AddEmployeeComponent from "./components/AddEmployeeComponent";

function App() {
  return (
    <div>
      <Router>
        <HeaderComponents />
        <Routes>
          {/* Route for the home page */}
          <Route exact path="/" element={<ListEmployeeComponents />} />
          {/* Route for the about page */}
          <Route path="/employees" element={<ListEmployeeComponents />} />
          {/* Route for the about page */}
          <Route path="/add-employee" element={<AddEmployeeComponent />} />
          <Route path="/edit-employee/:id" element={<AddEmployeeComponent />} />
        </Routes>
        <FooterComponents />
      </Router>
    </div>
  );
}

export default App;
