package com.demo.templatespringboot.service;

import com.demo.templatespringboot.api.exception.NoSuchElementFoundException;
import com.demo.templatespringboot.api.model.EmployerDTO;
import com.demo.templatespringboot.infra.converter.EmployerConverter;
import com.demo.templatespringboot.persistence.entity.Employer;
import com.demo.templatespringboot.persistence.repository.EmployerRepository;
import com.demo.templatespringboot.stubs.dto.EmployerDTOStub;
import com.demo.templatespringboot.stubs.entity.EmployerStub;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class EmployerServiceTest {
    @InjectMocks
    private EmployerService service;
    @Mock
    private EmployerRepository repository;
    @Mock
    private EmployerConverter converter;
    private AutoCloseable closeable;
    EmployerDTO expected;
    Employer expectedEntity;
    List<EmployerDTO> expectedList;

    List<Employer> expectedEntityList;

    @BeforeEach
    public void setup() {
        closeable = MockitoAnnotations.openMocks(this);
        expectedEntity = EmployerStub.any();
        expected = EmployerDTOStub.any();
        expectedList = EmployerDTOStub.anyList();
        expectedEntityList = EmployerStub.anyList();
    }

    @Test
    void testCreate() {
        doReturn(expectedEntity)
                .when(repository)
                .save(expectedEntity);
        mockMapper();

        EmployerDTO actual = this.service.create(expected);
        assertEquals(expected, actual);
    }

    @Test
    void testSave() {
        doReturn(expectedEntity)
                .when(repository)
                .save(expectedEntity);
        mockMapper();

        EmployerDTO actual = this.service.save(expected);
        assertEquals(expected, actual);
    }

    @Test
    void testFindById() {
        doReturn(Optional.of(expectedEntity))
                .when(repository)
                .findById(expected.getId());
        mockMapper();

        EmployerDTO actual = this.service.findById(expected.getId());
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

        List<EmployerDTO> actualList = this.service.findAll();

        assertEquals(expectedList, actualList);
        assertEquals(expectedList.size(), actualList.size());
    }

    @Test
    void testFindAllEmptyList() {
        doReturn(Collections.emptyList())
                .when(repository)
                .findAll();

        List<EmployerDTO> actualList = this.service.findAll();

        assertEquals(Collections.emptyList(), actualList);
        assertEquals(0, actualList.size());
    }

    @Test
    void testDeleteById() {
        Long id = expected.getId();
        doNothing()
                .when(repository)
                .deleteById(id);
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
        EmployerDTO actual = service.update(expected);

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
