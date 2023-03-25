package com.mock.assessment.dao.impl;

import com.mock.assessment.dao.BranchDAO;
import com.mock.assessment.model.entity.Branch;
import com.mock.assessment.model.entity.Employee;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class BranchDAOImpl implements BranchDAO {

  private static final Logger LOGGER = LogManager.getLogger(BranchDAOImpl.class.getName());

  private final SessionFactory sessionFactory;

  public BranchDAOImpl(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }
  /**
   * creates the branch
   *
   * @param branch employee branch
   */
  @Override
  public void createBranch(Branch branch) {
    Session session = this.sessionFactory.openSession();
    Employee employee = new Employee();
    employee.setName("Libu Mathew");
    List<Employee> employees = new ArrayList<>();
    employees.add(employee);
    branch.setEmployee(employees);
    session.save(branch);
  }
}
