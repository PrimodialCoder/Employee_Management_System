package com.app.ems.controller;

import com.app.ems.dto.EmployeeDto;
import com.app.ems.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@AllArgsConstructor
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    //Build REST API for create employee
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {// this request body will be convert json from request to EmployeeDto object
        // it is a method that handles HTTP POST requests to create a new employee it is getting the employee data from the request body and inside it it calls employeeService to create the employee in the database
        EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    //Build REST API for get employee by id
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployees(@PathVariable("id") Long employeeId) {
        EmployeeDto savedEmployee = employeeService.getEmployeeById(employeeId);
        return ResponseEntity.ok(savedEmployee);
    }

    //Build REST API for get all employees
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
        List<EmployeeDto> allEmployees = employeeService.getAllEmployees();
        if (allEmployees.isEmpty()) {
            return ResponseEntity.noContent().build(); // Return 204 No Content if the list is empty
        }
        return ResponseEntity.ok(allEmployees);
    }

    //Build REST API for update employee
    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long employeeId,
                                                  @RequestBody EmployeeDto employeeDto) {
        EmployeeDto updatedEmployee = employeeService.updateEmployee(employeeId, employeeDto);
        return ResponseEntity.ok(updatedEmployee);
    }

    //Build REST API for delete employee
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId) {
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok( employeeId+ "- Employee deleted successfully");
    }

    //Build REST API for delete all employees
    @DeleteMapping
    public ResponseEntity<String> deleteAllEmployees() {
        employeeService.deleteAllEmployees();
        return ResponseEntity.ok("All Employees are deleted and auto-increment id also got reseted"); // Return 204 No Content after successful deletion
    }


}
