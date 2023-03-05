package com.mock.assessment.controller;

import com.mock.assessment.model.dto.BranchDto;
import com.mock.assessment.service.BranchService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

@Api(value = "Branch controller")
@RequestMapping(value = "/branches", consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
@RestController
public class BranchController {
    private static final Logger LOGGER = LogManager.getLogger(BranchController.class.getName());

    @Autowired
    BranchService branchService;

    @ApiOperation(value = "create branch")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 500, message = "Internal Server Error!"),
            @ApiResponse(code = 204, message = "No Content!")})
    @PostMapping()
    public Response createBranch(@RequestBody BranchDto branchDto) {
        LOGGER.info("create branch with name: {}", branchDto.getName());
        branchService.createBranch(branchDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/branches").buildAndExpand("/branches").toUri();
        return Response.status(Response.Status.CREATED).entity(uri).build();
    }

}
