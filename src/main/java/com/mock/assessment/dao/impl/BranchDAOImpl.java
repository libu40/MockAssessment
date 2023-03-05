package com.mock.assessment.dao.impl;

import com.mock.assessment.dao.BranchDAO;
import com.mock.assessment.model.entity.Branch;
import com.mock.assessment.model.entity.Employee;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BranchDAOImpl implements BranchDAO {

    private static final Logger LOGGER = LogManager.getLogger(BranchDAOImpl.class.getName());
    @Autowired
    private SessionFactory sessionFactory;

    /**
     * creates the branch
     *
     * @param branch employee branch
     */
    @Override
    public void createBranch(Branch branch) {
        Session session = this.sessionFactory.getCurrentSession();
        Employee employee = new Employee();
        employee.setName("Libu Mathew");
        List<Employee> employees = new ArrayList<>();
        employees.add(employee);
        branch.setEmployee(employees);
        session.save(branch);
    }
}
