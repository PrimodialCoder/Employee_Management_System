package com.app.ems.service.impl;

import com.app.ems.dto.EmployeeDto;
import com.app.ems.mapper.EmployeeMapper;
import com.app.ems.repository.EmployeeRepository;
import com.app.ems.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.app.ems.entity.Employee;

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
}
