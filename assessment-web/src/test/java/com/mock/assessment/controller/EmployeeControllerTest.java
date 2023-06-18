package com.mock.assessment.controller;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static org.hamcrest.Matchers.aMapWithSize;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.BEFORE_TEST_METHOD;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mock.assessment.dto.EmployeeDto;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@SqlGroup({
    @Sql(value = "classpath:dataset/reset.sql", executionPhase = BEFORE_TEST_METHOD),
    @Sql(value = "classpath:dataset/employee-data.sql", executionPhase = BEFORE_TEST_METHOD)
})
@ActiveProfiles(profiles = "test")
class EmployeeControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  void testGetAllMockedEmployeesIsOK() throws Exception {
    mockMvc
        .perform(MockMvcRequestBuilders.get("/assessment/employees").contextPath("/assessment"))
        .andExpect(status().isOk());
  }

  @Test
  void testGetAllRealEmployeesIsOK() throws Exception {
    mockMvc
        .perform(MockMvcRequestBuilders.get("/assessment/employees").contextPath("/assessment"))
        .andExpect(status().isOk());
  }

  @Test
  void testCreateEmployee() throws Exception {
    this.mockMvc.perform(post("/user/create")
            .contentType(APPLICATION_JSON)
            .content(asJsonString(new EmployeeDto(1, "test employee"))))
        .andDo(print())
        .andExpect(status().isCreated()).andExpect(jsonPath("$").isMap())
        .andExpect(jsonPath("$", aMapWithSize(3)));
  }

  static String asJsonString(final Object obj) {
    try {
      return new ObjectMapper().writeValueAsString(obj);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
