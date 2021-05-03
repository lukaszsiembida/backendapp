package pl.luxmed.backendapp.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.annotation.DirtiesContext;
import pl.luxmed.backendapp.dto.DepartmentDto;
import pl.luxmed.backendapp.service.DepartmentService;

import java.util.List;

import static org.mockito.Mockito.when;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
//czysci kontekst aplikacji, uruchamia ją od nowa
@ExtendWith(MockitoExtension.class)
class DepartmentControllerTest {

    @Mock(lenient = true)
    DepartmentService departmentService;

    DepartmentController departmentControllerMock;


    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(departmentControllerMock);
        departmentControllerMock = new DepartmentController(departmentService);
    }

//    @Test
//    void shouldGetDepartments() {
//        when(departmentService.getDepartments()).thenReturn(departmentDto);
//    }


    @Test
    void addDepartment() {
    }


    @Test
    void deleteDepartmentById() {
    }
}