package com.mock.assessment.service;

import com.mock.assessment.dto.EmployeeDto;
import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<EmployeeDto> getAllEmployees();

    void saveEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(int id);
}
