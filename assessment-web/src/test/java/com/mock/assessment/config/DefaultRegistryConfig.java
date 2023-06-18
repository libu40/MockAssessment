package com.mock.assessment.config;

import com.mock.assessment.dao.EmployeeDAO;
import com.mock.assessment.mapper.EmployeeMapper;
import com.mock.assessment.service.EmployeeService;
import com.mock.assessment.service.impl.EmployeeServiceImpl;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public
class DefaultRegistryConfig {

  @MockBean
  private EmployeeDAO employeeDAO;
  @MockBean
  private EmployeeMapper employeeMapper;

  @Bean
  EmployeeService employeeService() {
    return new EmployeeServiceImpl(employeeDAO, employeeMapper);
  }
}
