package com.mock.assessment.dao.impl;

import com.mock.assessment.dao.BranchDAO;
import com.mock.assessment.model.entity.Branch;
import com.mock.assessment.model.entity.Employee;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
    Transaction transaction = null;
    LOGGER.info("save branch with name: {} ", branch.getName());
    try (Session session = this.sessionFactory.openSession()) {
      transaction = session.beginTransaction();
      Employee employee = new Employee();
      employee.setName("Libu Mathew");
      Set<Employee> employees = new HashSet<>();
      employees.add(employee);
      branch.setEmployee(employees);
      session.save(branch);
      transaction.commit();
    } catch (Exception exception) {
      LOGGER.error("Unable to create the branch: {} ", branch.getName());
      transaction.rollback();
    }
  }

  /**
   * Fetches all the branches
   *
   * @return branches
   */
  @Override
  public List<Branch> fetchAllBranches() {
    LOGGER.info("fetching all the branches");
    try (Session session = this.sessionFactory.openSession()) {
      CriteriaBuilder builder = session.getCriteriaBuilder();
      CriteriaQuery<Branch> branchCriteriaQuery = builder.createQuery(Branch.class);
      branchCriteriaQuery.from(Branch.class);
      return session.createQuery(branchCriteriaQuery).getResultList();
    } catch (Exception exception) {
      LOGGER.error("Unable to fetch the branches");
    }
    sessionFactory.close();
    return new ArrayList<>();
  }
}
