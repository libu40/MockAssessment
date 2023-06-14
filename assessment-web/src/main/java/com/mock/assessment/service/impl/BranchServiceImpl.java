package com.mock.assessment.service.impl;

import com.mock.assessment.dao.BranchDAO;
import com.mock.assessment.mapper.BranchMapper;
import com.mock.assessment.dto.BranchDto;
import com.mock.assessment.model.entity.Branch;
import com.mock.assessment.service.BranchService;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BranchServiceImpl implements BranchService {

  private static final Logger LOGGER = LogManager.getLogger(BranchServiceImpl.class.getName());

  private final BranchDAO branchDAO;

  private final BranchMapper branchMapper;

  public BranchServiceImpl(BranchDAO branchDAO, BranchMapper branchMapper) {
    this.branchDAO = branchDAO;
    this.branchMapper = branchMapper;
  }

  /**
   * creates a branch
   *
   * @param branch branch request
   */
  @Override
  @Transactional
  public void createBranch(BranchDto branch) {
    LOGGER.info("save employee branch with name: {}", branch.getName());
    Branch employeeBranch = branchMapper.mapToBranchEntity(branch);
    branchDAO.createBranch(employeeBranch);
  }

  /** Fetch branches
   * @return branches
   */
  @Override
  public List<BranchDto> getBranches() {
    List<Branch> branches = branchDAO.fetchAllBranches();
    List<BranchDto> consolidatedBranches =
        branches.stream().map(branchMapper::mapToBranchDTO).collect(Collectors.toList());
    LOGGER.info("the number of branches  fetched are of size:{} ", consolidatedBranches.size());
    return consolidatedBranches;
  }
}
