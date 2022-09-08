package com.demo.templatespringboot.service;

import com.demo.templatespringboot.api.exception.NoSuchElementFoundException;
import com.demo.templatespringboot.api.model.DepartmentDTO;
import com.demo.templatespringboot.infra.converter.DepartmentConverter;
import com.demo.templatespringboot.persistence.entity.Department;
import com.demo.templatespringboot.persistence.repository.DepartmentRepository;
import com.demo.templatespringboot.persistence.repository.EmployerRepository;
import com.demo.templatespringboot.stubs.dto.DepartmentDTOStub;
import com.demo.templatespringboot.stubs.entity.DepartmentStub;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class DepartmentServiceTest {
    @InjectMocks
    private DepartmentService service;
    @Mock
    private DepartmentRepository repository;
    @Mock
    private EmployerRepository employerRepository;
    @Mock
    private DepartmentConverter converter;
    private AutoCloseable closeable;
    DepartmentDTO expected;
    Department expectedEntity;
    List<DepartmentDTO> expectedList;

    List<Department> expectedEntityList;

    @BeforeEach
    public void setup() {
        closeable = MockitoAnnotations.openMocks(this);
        expectedEntity = DepartmentStub.any();
        expected = DepartmentDTOStub.any();
        expectedList = DepartmentDTOStub.anyList();
        expectedEntityList = DepartmentStub.anyList();
    }

    @Test
    void testCreate() {
        doReturn(expectedEntity)
                .when(repository)
                .save(expectedEntity);
        mockMapper();

        DepartmentDTO actual = this.service.create(expected);
        assertEquals(expected, actual);
    }

    @Test
    void testSave() {
        doReturn(expectedEntity)
                .when(repository)
                .save(expectedEntity);
        mockMapper();

        DepartmentDTO actual = this.service.save(expected);
        assertEquals(expected, actual);
    }

    @Test
    void testFindById() {
        doReturn(Optional.of(expectedEntity))
                .when(repository)
                .findById(expected.getId());
        mockMapper();

        DepartmentDTO actual = this.service.findById(expected.getId());
        assertEquals(expected, actual);
    }

    @Test()
    void testFindByIdNotFound() {
        Long id = expected.getId();
        doReturn(Optional.empty())
                .when(repository)
                .findById(id);
        mockMapper();

        assertThrows(NoSuchElementFoundException.class, () -> {
            this.service.findById(id);
        });

    }

    @Test
    void testFindAll() {
        doReturn(expectedEntityList)
                .when(repository)
                .findAll();
        mockMapperList();

        List<DepartmentDTO> actualList = this.service.findAll();

        assertEquals(expectedList, actualList);
        assertEquals(expectedList.size(), actualList.size());
    }

    @Test
    void testFindAllEmptyList() {
        doReturn(Collections.emptyList())
                .when(repository)
                .findAll();

        List<DepartmentDTO> actualList = this.service.findAll();

        assertEquals(Collections.emptyList(), actualList);
        assertEquals(0, actualList.size());
    }

    @Test
    void testDeleteById() {
        Long id = expected.getId();
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
        Long id = expected.getId();
        doReturn(expectedEntity)
                .when(repository)
                .save(any());
        mockMapper();
        DepartmentDTO actual = service.update(expected);

        assertEquals(expected, actual);
    }

    private void mockMapper() {
        doReturn(expectedEntity).when(converter).toModel(expected);
        doReturn(expected).when(converter).fromModel(expectedEntity);
    }

    private void mockMapperList() {
        doReturn(expectedEntityList).when(converter).toModelList(expectedList);
        doReturn(expectedList).when(converter).fromModelList(expectedEntityList);
    }

    @AfterEach
    public void close() throws Exception {
        closeable.close();
    }

}
