package com.mock.assessment.mapper;

import com.mock.assessment.model.dto.BranchDto;
import com.mock.assessment.model.entity.Branch;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BranchMapper {

    BranchDto mapToBranchDTO(Branch branch);

    Branch mapToBranchEntity(BranchDto branchDto);


}
