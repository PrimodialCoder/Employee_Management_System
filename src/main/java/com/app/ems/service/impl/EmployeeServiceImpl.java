package com.app.ems.service.impl;

import com.app.ems.dto.EmployeeDto;
import com.app.ems.exception.ResourceNotFoundException;
import com.app.ems.mapper.EmployeeMapper;
import com.app.ems.repository.EmployeeRepository;
import com.app.ems.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.app.ems.entity.Employee;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;// Injecting the EmployeeRepository dependency
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        // Convert EmployeeDto to Employee jpa entity
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee not found with id: " + employeeId));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> allEmployees = employeeRepository.findAll();
        //we can do this conversion of List of employee to list of emplyeeDto using stream api but for now we will do it using for loop
        List<EmployeeDto> employeeDtos = new ArrayList<>();
        for (Employee employee : allEmployees) {
            EmployeeDto employeeDto = EmployeeMapper.mapToEmployeeDto(employee);
            employeeDtos.add(employeeDto);
        }
        return employeeDtos;
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto employeeDto) {
        Employee updatedEmployee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee not found with id: " + employeeId)
        );
        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setEmail(updatedEmployee.getEmail());

        Employee updatedEmployeeObj = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);
    }


}
