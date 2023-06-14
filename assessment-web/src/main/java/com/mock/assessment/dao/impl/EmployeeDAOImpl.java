package com.mock.assessment.dao.impl;

import com.mock.assessment.dao.EmployeeDAO;
import com.mock.assessment.model.entity.Employee;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

  private static final Logger LOGGER = LogManager.getLogger(EmployeeDAOImpl.class.getName());

  /**
   * Save employee
   *
   * @param employee employee
   */
  @Override
  public void saveEmployee(Employee employee) {}

  /**
   * fetch all employees
   *
   * @return employees
   */
  @Override
  public Optional<List<Employee>> fetchAllEmployees() {
    LOGGER.info("total number of employees fetched are the count:");
    List<Employee> employees = new ArrayList<>();
    return Optional.of(employees);
  }
}
