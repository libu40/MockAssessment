package com.mock.assessment.mapper;

import com.mock.assessment.model.dto.EmployeeDto;
import com.mock.assessment.model.entity.Employee;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    Employee mapToEmployeeEntity(EmployeeDto employeeDto);

    EmployeeDto mapToEmployeeDTO(Employee employee);
}
