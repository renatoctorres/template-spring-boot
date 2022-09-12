package com.rct.humanresources.infra.delivery;

import com.rct.humanresources.core.model.DepartmentDTO;
import com.rct.humanresources.core.service.DepartmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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
 * Department Controller - Rest API
 *
 */
@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService service;
    private static final Logger logger = getLogger(DepartmentController.class);

    @Autowired
    public DepartmentController(DepartmentService service){
        this.service = service;
    }

    /**
     * GET Http Method
     * @param id Long
     * @return DepartmentDTO
     */
    @GetMapping("/{id}")
    @ResponseStatus(OK)
    @Operation(description = "Get Department by ID", responses = {
            @ApiResponse(responseCode = "404"  , description = "The Department", content =
            @Content(mediaType = APPLICATION_JSON, schema =
            @Schema(implementation = DepartmentDTO.class))),
            @ApiResponse(responseCode = "404", description = "Department Not Found", content =
            @Content(mediaType = APPLICATION_JSON)),
    })
    DepartmentDTO findById(@PathVariable Long id){
        logger.info("Searching Department by ID {}", id);
        return this.service.findById(id);
    }

    /**
     * GET Http Method - List Departments
     * Find All Method
     * @return Department DTO List
     */
    @GetMapping
    @ResponseStatus(OK)
    List<DepartmentDTO> findAll(){
        logger.info( "Searching All Departments");
        return this.service.findAll();
    }

    /**
     * POST Http Method - Create Department
     * @param dto DepartmentDTO
     * @return DepartmentDTO
     */
    @PostMapping
    @ResponseStatus(CREATED)
    DepartmentDTO create(DepartmentDTO dto){
        logger.debug("Creating Department {}", dto);
        return this.service.create(dto);
    }

    /**
     * PUT Http Method - Update Department
     * @param dto DepartmentDTO
     * @return DepartmentDTO
     */
    @PutMapping
    @ResponseStatus(CREATED)
    DepartmentDTO update(DepartmentDTO dto){
        logger.debug("Updating Department {}", dto);
        return this.service.update(dto);
    }

    /**
     * DELETE Http Method - Delete Department by Id
     * @param id Long
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    void deleteById(@PathVariable Long id) {
        logger.warn( "Searching Department by ID {}", id);
        this.service.deleteById(id);
    }

}
