package com.mock.assessment.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * The DTO responsible for holding the branch related attributes information.
 */

@AllArgsConstructor
@Data
public class BranchDto {

    @JsonProperty("id")
    private int id;

    @JsonProperty("name")
    @NotBlank
    private String name;
}
