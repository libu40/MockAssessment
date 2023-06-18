package com.mock.assessment.dao;

import com.mock.assessment.model.entity.Branch;
import java.util.Date;
import java.util.HashSet;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BranchDaoTest {

  @Autowired
  BranchDAO branchDAO;

  @Test
  public void createBranch() {
    Branch branch = new Branch("CSE", new Date(), new Date(), new HashSet<>());
    branchDAO.createBranch(new Branch());
    Assert.assertNotNull(branchDAO.fetchAllBranches());
  }

}
