package com.mock.assessment.dao;

import com.mock.assessment.model.entity.Branch;import java.util.List;

public interface BranchDAO {

    void createBranch(Branch branch);
List<Branch> fetchAllBranches();}
