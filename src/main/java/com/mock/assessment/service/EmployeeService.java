package com.mock.assessment.service;

import com.mock.assessment.model.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDto> getAllEmployees();

    void saveEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(int id);
}
