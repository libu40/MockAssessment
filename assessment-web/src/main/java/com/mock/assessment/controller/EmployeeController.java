package com.mock.assessment.controller;

import com.mock.assessment.model.dto.EmployeeDto;
import com.mock.assessment.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.net.URI;
import java.util.List;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Api(value = "Employee controller")
@RequestMapping(
    value = "/employees",
    consumes = MediaType.APPLICATION_JSON,
    produces = MediaType.APPLICATION_JSON)
@RestController
public class EmployeeController {
  private static final Logger LOGGER = LogManager.getLogger(EmployeeController.class.getName());

  private final EmployeeService employeeService;

  EmployeeController(EmployeeService employeeService) {
    this.employeeService = employeeService;
  }

  @ApiOperation(value = "get employee by id", response = EmployeeDto.class)
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "Success|OK"),
        @ApiResponse(code = 500, message = "Internal Server Error!"),
        @ApiResponse(code = 404, message = "Not Found!")
      })
  @GetMapping("/employees/{id}")
  public Response getEmployeeById(@PathVariable int id) {
    LOGGER.info("fetch employee with id: {}", id);
    EmployeeDto employeeDto = employeeService.getEmployeeById(id);
    return Response.status(Response.Status.OK).entity(employeeDto).build();
  }

  @ApiOperation(value = "get employees", response = EmployeeDto.class)
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "Success|OK"),
        @ApiResponse(code = 500, message = "Internal Server Error!"),
        @ApiResponse(code = 404, message = "Not Found!")
      })
  @GetMapping("/employees")
  public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
    LOGGER.info("Fetching all the employees");
    List<EmployeeDto> employees = employeeService.getAllEmployees();
    return ResponseEntity.ok().body(employees);
  }

  @ApiOperation(value = "create employee")
  @ApiResponses(
      value = {
        @ApiResponse(code = 201, message = "Created"),
        @ApiResponse(code = 500, message = "Internal Server Error!"),
        @ApiResponse(code = 204, message = "No Content!")
      })
  @PostMapping()
  public ResponseEntity<String> createEmployee(@RequestBody EmployeeDto employee) {
    LOGGER.info("create employee with name: {}", employee.getName());
    employeeService.saveEmployee(employee);
    URI uri =
        ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{label}")
            .buildAndExpand("/employees")
            .toUri();
    return ResponseEntity.created(uri).build();
  }
}
