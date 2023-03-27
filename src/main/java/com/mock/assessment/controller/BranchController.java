package com.mock.assessment.controller;

import com.mock.assessment.model.dto.BranchDto;
import com.mock.assessment.service.BranchService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.net.URI;
import java.util.List;
import javax.ws.rs.core.MediaType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Api(value = "Branch controller")
@RequestMapping(
    value = "/branches",
    consumes = MediaType.APPLICATION_JSON,
    produces = MediaType.APPLICATION_JSON)
@RestController
public class BranchController {
  private static final Logger LOGGER = LogManager.getLogger(BranchController.class.getName());

  private final BranchService branchService;

  public BranchController(BranchService branchService) {
    this.branchService = branchService;
  }

  @ApiOperation(value = "create branch")
  @ApiResponses(
      value = {
        @ApiResponse(code = 201, message = "Created"),
        @ApiResponse(code = 500, message = "Internal Server Error!"),
        @ApiResponse(code = 204, message = "No Content!")
      })
  @PostMapping()
  public ResponseEntity<String> createBranch(@RequestBody BranchDto branchDto) {
    LOGGER.info("create branch with name: {}", branchDto.getName());
    branchService.createBranch(branchDto);
    URI uri =
        ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/branches")
            .buildAndExpand("/branches")
            .toUri();
    return ResponseEntity.created(uri).build();
  }

  @ApiOperation(value = "get branches", response = BranchDto.class)
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "Success|OK"),
        @ApiResponse(code = 500, message = "Internal Server Error!")
      })
  @GetMapping()
  public ResponseEntity<List<BranchDto>> getAllBranches() {
    LOGGER.info("Fetching all the branches");
    List<BranchDto> branches = branchService.getBranches();
    return ResponseEntity.ok().body(branches);
  }
}
