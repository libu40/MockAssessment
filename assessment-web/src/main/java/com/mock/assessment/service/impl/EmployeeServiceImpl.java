package com.mock.assessment.service.impl;

import com.mock.assessment.dao.EmployeeDAO;
import com.mock.assessment.dto.EmployeeDto;
import com.mock.assessment.mapper.EmployeeMapper;
import com.mock.assessment.model.entity.Employee;
import com.mock.assessment.service.EmployeeService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

  private final EmployeeDAO employeeDAO;

  private final EmployeeMapper employeeMapper;

  public EmployeeServiceImpl(EmployeeDAO employeeDAO, EmployeeMapper employeeMapper) {
    this.employeeDAO = employeeDAO;
    this.employeeMapper = employeeMapper;
  }

  private static final Logger LOGGER = LogManager.getLogger(EmployeeServiceImpl.class);

  /**
   * fetches all the employees
   *
   * @return employees
   */
  @Override
  public List<EmployeeDto> getAllEmployees() {
    Optional<List<Employee>> employees = employeeDAO.fetchAllEmployees();
    if (employees.isPresent()) {
      LOGGER.info("the number of employees fetched are of size:{} ", employees.get().size());
      return employees.get().stream()
          .map(employeeMapper::mapToEmployeeDTO)
          .collect(Collectors.toList());
    }
    return new ArrayList<>();
  }

  /**
   * save an employee
   *
   * @param employee employee
   */
  @Override
  @Transactional
  public void saveEmployee(EmployeeDto employee) {
    LOGGER.info("persisting employee with name: {}", employee.getName());
    employeeDAO.saveEmployee(employeeMapper.mapToEmployeeEntity(employee));
  }

  /**
   * fetches employee by id
   *
   * @param id employee id
   * @return employee
   */
  @Override
  public EmployeeDto getEmployeeById(int id) {
    return null;
  }
}
