package com.mock.assessment.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import com.mock.assessment.dao.BranchDAO;
import com.mock.assessment.mapper.BranchMapper;
import com.mock.assessment.model.dto.BranchDto;
import com.mock.assessment.model.entity.Branch;
import com.mock.assessment.service.impl.BranchServiceImpl;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class BranchServiceImplTest {
  @Mock BranchDAO branchDAO;
  @Mock BranchMapper branchMapper;
  @InjectMocks BranchServiceImpl branchServiceImpl;

  Branch branch = new Branch();

  List<Branch> branches = new ArrayList<>();

  @Before
  public void setUp() {
    MockitoAnnotations.openMocks(this);
    branch.setId(1);
    branch.setName("CSE");
    branches.add(branch);
  }

  @Test
  public void testCreateBranch() {
    when(branchMapper.mapToBranchEntity(any())).thenReturn(branch);
    Mockito.doNothing().when(branchDAO).createBranch(branch);
    branchServiceImpl.createBranch(new BranchDto(1, "CSE"));
    verify(branchDAO, times(1)).createBranch(branch);
  }

  @Test(expected = Exception.class)
  public void testEmptyBranch() {
    when(branchMapper.mapToBranchEntity(any())).thenReturn(nullable(Branch.class));
    Mockito.doNothing().when(branchDAO).createBranch(branch);
    branchServiceImpl.createBranch(new BranchDto(1, "CSE"));
  }

  @Test
  public void testFetchingAllBranches() {
    when(branchDAO.fetchAllBranches()).thenReturn(branches);
    when(branchMapper.mapToBranchDTO(branch)).thenReturn(new BranchDto(1, "CSE"));
    List<BranchDto> branches = branchServiceImpl.getBranches();
    assertEquals(1, branches.size());
  }
}
