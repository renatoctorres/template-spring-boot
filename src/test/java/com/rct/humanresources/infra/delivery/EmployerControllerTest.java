package com.rct.humanresources.infra.delivery;

import com.rct.humanresources.TemplateSpringBootApplication;
import com.rct.humanresources.core.model.EmployerDTO;
import com.rct.humanresources.core.service.EmployerService;
import com.rct.humanresources.core.stubs.dto.EmployerDTOStub;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EmployerController.class)
@ContextConfiguration(classes= TemplateSpringBootApplication.class)
class EmployerControllerTest {
    @MockBean
    private EmployerService service;
    @Autowired
    private MockMvc mockMvc;
    private final List<EmployerDTO> expectedDTOs = EmployerDTOStub.anyList();
    @Test
    void assertReturnSuccessWhenFindAll() throws Exception {
        given(service.findAll()).willReturn(expectedDTOs);
        mockMvc.perform(get("/employers")
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
