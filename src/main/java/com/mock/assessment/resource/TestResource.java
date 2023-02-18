package com.mock.assessment.resource;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "test controller")
@RequestMapping("/test")
@RestController
public class TestResource {

    private static final Logger LOGGER = LogManager.getLogger(TestResource.class);
    @ApiOperation(value = "Test service", response = String.class, tags = "test")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 401, message = "Not Authorized!"),
            @ApiResponse(code = 403, message = "Forbidden!"),
            @ApiResponse(code = 404, message = "Not Found!")})
    @GetMapping("/author/{name}")
    public String getAuthor(@PathVariable String name) {
        LOGGER.info("Author is {}",name);
        return name;
    }

}


