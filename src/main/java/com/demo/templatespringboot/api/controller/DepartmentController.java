package com.demo.templatespringboot.api.controller;

import com.demo.templatespringboot.api.exception.ApiError;
import com.demo.templatespringboot.api.model.DepartmentDTO;
import com.demo.templatespringboot.service.DepartmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.MediaType;
import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    private DepartmentService service;

    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(description = "Get Department by ID", responses = {
            @ApiResponse(responseCode = "200", description = "The Department", content =
            @Content(mediaType = MediaType.APPLICATION_JSON, schema =
            @Schema(implementation = DepartmentDTO.class))),
            @ApiResponse(responseCode = "404", description = "Department Not Found", content =
            @Content(mediaType = MediaType.APPLICATION_JSON, schema =
            @Schema(implementation = ApiError.class))),
    })
    private DepartmentDTO findById(@PathVariable Long id){
        LOGGER.info("Searching Department by ID {}", id);
        return this.service.findById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    private List<DepartmentDTO> findAll(){
        LOGGER.info( "Searching All Departments");
        return this.service.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private DepartmentDTO create(DepartmentDTO dto){
        LOGGER.debug("Creating Department {}", dto);
        return this.service.create(dto);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    private DepartmentDTO update(DepartmentDTO dto){
        LOGGER.debug("Updating Department {}", dto);
        return this.service.update(dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void deleteById(Long id) {
        LOGGER.warn( "Searching Department by ID {}", id);
        this.service.deleteById(id);
    }

}
