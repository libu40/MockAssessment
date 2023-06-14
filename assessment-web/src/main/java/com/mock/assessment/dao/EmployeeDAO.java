package com.mock.assessment.dao;

import com.mock.assessment.model.entity.Employee;
import java.util.List;
import java.util.Optional;

public interface EmployeeDAO {
    void saveEmployee(Employee employee);

    Optional<List<Employee>> fetchAllEmployees();

}
