package com.demo.templatespringboot.api.controller;

import com.demo.templatespringboot.api.exception.ApiError;
import com.demo.templatespringboot.api.model.EmployerDTO;
import com.demo.templatespringboot.service.EmployerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.MediaType;
import java.util.List;

@RestController
@RequestMapping("/employer")
public class EmployerController {
    @Autowired
    private EmployerService service;

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployerController.class);

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(description = "Get Employer by ID", responses = {
            @ApiResponse(description = "The Employer", content =
            @Content(mediaType = MediaType.APPLICATION_JSON, schema =
            @Schema(implementation = EmployerDTO.class))),
            @ApiResponse(responseCode = "404", description = "Employer Not Found", content =
            @Content(mediaType = MediaType.APPLICATION_JSON, schema =
            @Schema(implementation = ApiError.class)))
    })
    private ResponseEntity<EmployerDTO> findById(@PathVariable Long id) {
        LOGGER.info("Searching Employer by ID {}", id);
        return ResponseEntity
                .ok(this.service.findById(id));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    private ResponseEntity<List<EmployerDTO>> findAll() {
        LOGGER.info("Searching All Employers");
        return ResponseEntity
                .ok(this.service.findAll());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private ResponseEntity<EmployerDTO> create(EmployerDTO dto) {
        LOGGER.debug("Creating Employer {}", dto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.service.create(dto));
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    private ResponseEntity<EmployerDTO> update(EmployerDTO dto) {
        LOGGER.debug("Updating Employer {}", dto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.service.update(dto));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void deleteById(Long id) {
        LOGGER.warn("Searching Employer by ID {}", id);
        this.service.deleteById(id);
    }

}
