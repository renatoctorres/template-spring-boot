package com.rct.humanresources.core.service;

import com.rct.humanresources.infra.delivery.exception.NoSuchElementFoundException;
import com.rct.humanresources.core.model.DepartmentDTO;
import com.rct.humanresources.core.mapper.DepartmentMapper;
import com.rct.humanresources.core.service.impl.DepartmentServiceImpl;
import com.rct.humanresources.infra.persistence.entity.Department;
import com.rct.humanresources.infra.persistence.repository.DepartmentRepository;
import com.rct.humanresources.infra.persistence.repository.EmployerRepository;
import com.rct.humanresources.core.stubs.dto.DepartmentDTOStub;
import com.rct.humanresources.core.stubs.entity.DepartmentStub;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static java.util.Collections.emptyList;
import static java.util.Optional.empty;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceTest {
    @InjectMocks
    private DepartmentServiceImpl service;
    @Mock
    private DepartmentRepository repository;
    @Mock
    private EmployerRepository employerRepository;
    @Mock
    private DepartmentMapper mapper;

    DepartmentDTO expectedDTO;
    List<DepartmentDTO> expectedDTOs;
    Department expectedModel;
    List<Department> expectedModels;

    @BeforeEach
    public void setup() {
        expectedModel = DepartmentStub.any();
        expectedDTO = DepartmentDTOStub.any();
        expectedDTOs = DepartmentDTOStub.anyList();
        expectedModels = DepartmentStub.anyList();
    }

    @Test
    void testCreate() {
        doReturn(expectedModel)
                .when(repository)
                .save(expectedModel);
        mockMapperModel();

        var actual = this.service.create(expectedDTO);
        Assertions.assertEquals(expectedDTO, actual);
    }

    @Test
    void testSave() {
        doReturn(expectedModel)
                .when(repository)
                .save(expectedModel);
        mockMapperModel();

        var actual = this.service.save(expectedDTO);
        Assertions.assertEquals(expectedDTO, actual);
    }

    @Test
    void testFindById() {
        doReturn(Optional.of(expectedModel))
                .when(repository)
                .findById(expectedDTO.getId());
        mockMapperDTO();

        var actual = this.service.findById(expectedDTO.getId());

        Assertions.assertEquals(expectedDTO, actual);
    }

    @Test()
    void testFindByIdNotFound() {
        var id = expectedDTO.getId();
        doReturn(empty())
                .when(repository)
                .findById(id);

        assertThrows(NoSuchElementFoundException.class, () -> this.service.findById(id));

    }

    @Test
    void testFindAll() {
        doReturn(expectedModels)
                .when(repository)
                .findAll();
        mockMapperList();

        var actualList = this.service.findAll();

        assertEquals(expectedDTOs, actualList);
        assertEquals(expectedDTOs.size(), actualList.size());
    }

    @Test
    void testFindAllEmptyList() {
        doReturn(emptyList())
                .when(repository)
                .findAll();

        var actualList = this.service.findAll();

        assertEquals(emptyList(), actualList);
        assertEquals(0, actualList.size());
    }

    @Test
    void testDeleteById() {
        var id = expectedDTO.getId();
        doNothing()
                .when(repository)
                .deleteById(id);
        doNothing()
                .when(employerRepository)
                .deleteByDepartmentId(id);

        service.deleteById(id);

        verify(repository, only()).deleteById(any());
    }

    @Test
    void testUpdate() {
        doReturn(expectedModel)
                .when(repository)
                .save(any());
        mockMapperModel();

        var actual = service.update(expectedDTO);

        Assertions.assertEquals(expectedDTO, actual);
    }

    private void mockMapperModel() {
        doReturn(expectedModel).when(mapper).fromDTO(expectedDTO);doReturn(expectedDTO).when(mapper).fromModel(expectedModel);
    }
    private void mockMapperDTO() {
        doReturn(expectedDTO).when(mapper).fromModel(expectedModel);
    }

    private void mockMapperList() {
        doReturn(expectedDTOs).when(mapper).fromModels(expectedModels);
    }

}
