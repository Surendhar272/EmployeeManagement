import React, { useEffect, useState } from "react";
import { Link, useNavigate, useParams } from "react-router-dom";
import EmployeeService from "../services/EmployeeService";

const AddEmployeeComponent = () => {
  const [firstName, setFirstName] = useState("");
  const [lastName, setLastName] = useState("");
  const [address, setAddress] = useState("");
  const [role, setRole] = useState("");
  const navigate = useNavigate();
  const { id } = useParams();

  const saveorupdateEmployee = async (e) => {
    e.preventDefault();
    const employee = { firstName, lastName, address, role };

    if (id) {
      EmployeeService.updateEmployee(id, employee)
        .then(() => {
          navigate("/employees");
        })
        .catch((error) => console.log(error));
    } else {
      EmployeeService.createEmployee(employee)
        .then((response) => {
          console.log(response.data);
          navigate("/employees");
        })
        .catch((error) => {
          console.log(error);
        });
    }
  };

  useEffect(() => {
    EmployeeService.getEmployeeById(id)
      .then((response) => {
        setFirstName(response.data.firstName);
        setLastName(response.data.lastName);
        setAddress(response.data.address);
        setRole(response.data.role);
      })
      .catch((error) => {
        console.log(error);
      });
  }, []);

  const title = () => {
    if (id) {
      return <h2 className="text-center"> Update Employee </h2>;
    } else {
      return <h2 className="text-center"> Add Employee </h2>;
    }
  };
  return (
    <div>
      <br />
      <br />
      <div className="container">
        <div className="row">
          <div className="card col-md-6 offset-md-3 offset-md-3">
            {title()}
            <div className="card-body">
              <form>
                <div className="form-group mb-2">
                  <label className="form-label">First Name :</label>
                  <input
                    type="text"
                    placeholder="Enter your first name"
                    name=" firstName"
                    className="form-control
                  value = {firstName}"
                    onChange={(e) => setFirstName(e.target.value)}
                  ></input>
                </div>
                <div className="form-group mb-2">
                  <label className="form-label">Last Name :</label>
                  <input
                    type="text"
                    placeholder="Enter Last name"
                    name=" lastName"
                    className="form-control
                  value = {lastName}"
                    onChange={(e) => setLastName(e.target.value)}
                  ></input>
                </div>
                <div className="form-group mb-2">
                  <label className="form-label">Address :</label>
                  <input
                    type="text"
                    placeholder="Enter your address"
                    name=" adddress"
                    className="form-control
                  value = {address}"
                    onChange={(e) => setAddress(e.target.value)}
                  ></input>
                </div>
                <div className="form-group mb-2">
                  <label className="form-label">Role :</label>
                  <input
                    type="text"
                    placeholder="Enter your role "
                    name=" role"
                    className="form-control
                  value = {role}"
                    onChange={(e) => setRole(e.target.value)}
                  ></input>
                </div>
                <button
                  className="btn btn-success"
                  onClick={(e) => saveorupdateEmployee(e)}
                >
                  Submit
                </button>
                <Link to="/employees" className="btn btn-danger">
                  Cancel
                </Link>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default AddEmployeeComponent;
