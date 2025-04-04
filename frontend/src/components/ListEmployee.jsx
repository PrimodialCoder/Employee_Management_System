import React, { useEffect, useState } from "react";
import { listEmployees } from "../services/EmployeeService";
import { useNavigate } from "react-router-dom";

const ListEmployee = () => {
  const [employees, setEmployees] = useState([]);
  const navigator = useNavigate();
  useEffect(() => {
    listEmployees()
      .then((response) => {
        setEmployees(response.data);
      })
      .catch((error) => {
        console.error(error);
      });
  }, []);

  function addNewEmployee() {
    navigator("/add-employee");
  }
  return (
    <div className="container">
      <h2 className="text-center mt-4">List Of Employees</h2>
      <div className="d-flex justify-content-end mb-2">
        <button
          type="button"
          className="btn btn-outline-primary"
          onClick={addNewEmployee}>
          Add Employee
        </button>
      </div>
      <table className="table table-striped table-bordered">
        <thead>
          <tr className="text-center">
            <th>Employee ID</th>
            <th>Employee First Name</th>
            <th>Employee Last Name</th>
            <th>Employee Email ID</th>
          </tr>
        </thead>
        <tbody>
          {employees.map((employee) => (
            <tr key={employee.id}>
              <td>{employee.id}</td>
              <td>{employee.firstName}</td>
              <td>{employee.lastName}</td>
              <td>{employee.email}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default ListEmployee;
