package com.mock.assessment.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The DTO responsible for holding the employee related attributes information.
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmployeeDto {

    @JsonProperty("id")
    private int id;

    @JsonProperty("name")
    @NotNull
    private String name;
}
