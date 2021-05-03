package pl.luxmed.backendapp.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import pl.luxmed.backendapp.dto.EmployeeDto;
import pl.luxmed.backendapp.dto.EmployeeResourceFactory;
import pl.luxmed.backendapp.entity.Department;
import pl.luxmed.backendapp.entity.Employee;
import pl.luxmed.backendapp.service.EmployeeService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ExtendWith(MockitoExtension.class)
class EmployeeControllerTest {


    @Mock(lenient = true)
    private EmployeeService employeeService;

    EmployeeController employeeControllerMock;

    private Department department1;
    private Department department2;
    private Employee employee1;
    private Employee employee2;

    @BeforeEach
    public void setUp() {
        employeeControllerMock = new EmployeeController(employeeService);

        department1 = new Department("IT");
        employee1 = new Employee("Jan", "Nowak", "94021300674", 3200.00, department1);

    }

    @Test
    void shouldAddDepartment() {
        //given
        EmployeeDto dto = EmployeeResourceFactory.fromEntity(employee1);

        //when-then
        when(employeeService.addEmployee(any())).thenReturn(dto);
        ResponseEntity<EmployeeDto> result = employeeControllerMock.addEmployee(dto);
        assertNotNull(result);
        assertEquals(dto, result.getBody());
    }

    @Test
    void shouldDeleteEmployeeById() {
        //given
        employeeControllerMock.deleteEmployeeById(1L);
        //when - then
        verify(employeeService).deleteEmployeeById(1L);

    }
}