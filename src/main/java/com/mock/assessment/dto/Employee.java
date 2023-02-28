package com.mock.assessment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The DTO responsible for holding the employee related attributes information.
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Employee {

    private int id;
    private String name;
}
