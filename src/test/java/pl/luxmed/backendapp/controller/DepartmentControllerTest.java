package pl.luxmed.backendapp.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import pl.luxmed.backendapp.dto.DepartmentDto;
import pl.luxmed.backendapp.dto.DepartmentResourceFactory;
import pl.luxmed.backendapp.entity.Department;
import pl.luxmed.backendapp.service.DepartmentService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ExtendWith(MockitoExtension.class)
class DepartmentControllerTest {


    @Mock(lenient = true)
    DepartmentService departmentService;

    DepartmentController departmentControllerMock;

    private Department department1;
    private String departmentName1;


    @BeforeEach
    public void setUp() {
        departmentControllerMock = new DepartmentController(departmentService);

        departmentName1 = "IT";
        department1 = new Department(departmentName1);

    }


    @Test
    void shouldAddDepartment() {
        //given
        DepartmentDto dto = DepartmentResourceFactory.fromEntity(department1);

        //when-then
        when(departmentService.addDepartment(any())).thenReturn(dto);
        ResponseEntity<DepartmentDto> result = departmentControllerMock.addDepartment(dto);
        assertNotNull(result);
        assertEquals(dto, result.getBody());
    }

    @Test
    void shouldDeleteDepartmentById() {
        //given
        departmentControllerMock.deleteDepartmentById(1L);
        //when - then
        verify(departmentService).deleteDepartmentById(1L);

    }
}