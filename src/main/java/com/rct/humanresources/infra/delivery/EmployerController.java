package com.rct.humanresources.infra.delivery;

import com.rct.humanresources.core.model.EmployerDTO;

import com.rct.humanresources.core.service.EmployerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;
import static org.apache.logging.log4j.LogManager.getLogger;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;

/**
 * Employer Controller - Rest API
 *
 */
@RestController
@RequestMapping("/employers")
public class EmployerController {
    EmployerService service;
    private static final Logger logger = getLogger(EmployerController.class);

    /**
     * Employer Controller Constructor
     * @param service EmployerService
     */
    @Autowired
    EmployerController(EmployerService service){
        this.service = service;
    }

    /**
     * GET Http Method - Get Department by ID
     * @param id String
     * @return ResponseEntity
     */
    @GetMapping("/{id}")
    @ResponseStatus(OK)
    @Operation(description = "Get Employer by ID", responses = {
            @ApiResponse(description = "The Employer", content =
            @Content(mediaType = APPLICATION_JSON, schema =
            @Schema(implementation = EmployerDTO.class))),
            @ApiResponse(responseCode = "404", description = "Employer Not Found", content =
            @Content(mediaType = APPLICATION_JSON))
    })
    ResponseEntity<EmployerDTO> findById(@PathVariable Long id) {
        logger.info("Searching Employer by ID {}", id);
        return ResponseEntity
                .ok(this.service.findById(id));
    }

    /**
     * GET Http Method - Get All Departments
     * @return ResponseEntity
     */
    @GetMapping
    @ResponseStatus(OK)
    ResponseEntity<List<EmployerDTO>> findAll() {
        logger.info("Searching All Employers");
        return ResponseEntity
                .ok(this.service.findAll());
    }

    /**
     * POST Http Method - Create Employer
     * @param dto Employer
     * @return ResponseEntity
     */
    @PostMapping
    @ResponseStatus(CREATED)
    ResponseEntity<EmployerDTO> create(EmployerDTO dto) {
        logger.debug("Creating Employer {}", dto);
        return ResponseEntity
                .status(CREATED)
                .body(this.service.create(dto));
    }

    /**
     * PUT Http Method - Update Department
     * @param dto Employer
     * @return ResponseEntity
     */
    @PutMapping
    @ResponseStatus(CREATED)
    ResponseEntity<EmployerDTO> update(EmployerDTO dto) {
        logger.debug("Updating Employer {}", dto);
        return ResponseEntity
                .status(CREATED)
                .body(this.service.update(dto));
    }

    /**
     * Delete Http Method - Delete Department by Id
     * @param id String
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    void deleteById(@PathVariable  Long id) {
        logger.warn("Searching Employer by ID {}", id);
        this.service.deleteById(id);
    }

}
