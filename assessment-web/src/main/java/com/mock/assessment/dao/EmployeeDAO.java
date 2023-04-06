package com.mock.assessment.dao;

import com.mock.assessment.model.entity.Employee;
import java.util.List;

public interface EmployeeDAO {
    void saveEmployee(Employee employee);

    List<Employee> fetchAllEmployees();

}
