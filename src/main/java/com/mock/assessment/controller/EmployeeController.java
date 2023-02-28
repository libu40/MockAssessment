package com.mock.assessment.controller;

import com.mock.assessment.dto.Employee;
import com.mock.assessment.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.core.Response;

@Api(value = "test controller")
@RequestMapping("/test")
@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    private static final Logger LOGGER = LogManager.getLogger(EmployeeController.class);

    @ApiOperation(value = "Test service", response = String.class, tags = "test")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 401, message = "Not Authorized!"),
            @ApiResponse(code = 403, message = "Forbidden!"),
            @ApiResponse(code = 404, message = "Not Found!")})
    @GetMapping("/author/{name}")
    public String getAuthor(@PathVariable String name) {
        LOGGER.info("Author is {}", name);
        return name;
    }

    @ApiOperation(value = "Get employees", response = Employee.class, tags = "test")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 500, message = "Internal Server Error!"),
            @ApiResponse(code = 404, message = "Not Found!")})
    @GetMapping("/employees")
    public Response getAllEmployees() {
        LOGGER.info("Fetch the list of employees");
        Employee employee = employeeService.getAllEmployees();
        return Response.status(Response.Status.OK).entity(employee).build();
    }
}


