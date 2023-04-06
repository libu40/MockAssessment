package com.mock.assessment.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

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
