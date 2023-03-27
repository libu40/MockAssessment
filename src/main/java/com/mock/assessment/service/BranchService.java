package com.mock.assessment.service;

import com.mock.assessment.model.dto.BranchDto;
import java.util.List;

public interface BranchService {
    void createBranch(BranchDto branch);
List<BranchDto> getBranches();}
