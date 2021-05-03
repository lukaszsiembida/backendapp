package pl.luxmed.backendapp.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.annotation.DirtiesContext;
import pl.luxmed.backendapp.dto.DepartmentResourceFactory;
import pl.luxmed.backendapp.dto.EmployeeDto;
import pl.luxmed.backendapp.dto.EmployeeResourceFactory;
import pl.luxmed.backendapp.entity.Department;
import pl.luxmed.backendapp.entity.Employee;
import pl.luxmed.backendapp.repository.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {

    @Mock(lenient = true)
    private EmployeeRepository employeeRepository;

    @Mock(lenient = true)
    private DepartmentService departmentService;

    EmployeeService employeeServiceMock;

    private Department department1;
    private Department department2;
    private Employee employee1;
    private Employee employee2;
    private Employee employee3;

    @BeforeEach
    public void setUp() {
        employeeServiceMock = new EmployeeService(employeeRepository, departmentService);
        MockitoAnnotations.initMocks(employeeServiceMock);

        department1 = new Department("IT");
        department2 = new Department("HR");
        employee1 = new Employee("Jan", "Nowak", "94021300674", 3200.00, department1);
        employee2 = new Employee("Julia", "Szoja", "87032300832", 3800.00, department1);
        employee3 = new Employee("Stefan", "Czarnecki", "56112312398", 4800.00, department2);
    }

    @Test
    void shouldAddEmployee() {

        /*//given
        EmployeeDto dto = EmployeeResourceFactory.fromEntity(employee1);
        //when //then
        when(EmployeeResourceFactory.fromEntity(employeeRepository.save(employee1))).thenReturn(dto);
        EmployeeDto resultDto = employeeServiceMock.addEmployee(dto);
        assertEquals(employee1, resultDto);*/

    }

    @Test
    void shouldGetListEmployees() {
        //given
        List<Employee> employees = new ArrayList<>();
        employees.add(employee1);
        //when
        //then
        when(employeeRepository.findAll()).thenReturn(employees);
        List<Employee> resultEmployees = employeeServiceMock.getListEmployees().stream()
                .map(EmployeeResourceFactory::toEntity).collect(Collectors.toList());
        assertNotNull(resultEmployees);
        assertEquals(employee1, resultEmployees.get(0));
        assertNotEquals(employee2, resultEmployees.get(0));
//
    }

    @Test
    void shouldGetListEmployeesByDepartmentId() {
        //given
        List<Employee> employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);
        //when then
        when(employeeRepository.findAllByDepartmentId(department1.getDepartmentId())).thenReturn(employees);

        List<Employee> resultEmployees = employeeServiceMock.getListEmployeesByDepartmentId(department1.getDepartmentId())
                .stream().map(EmployeeResourceFactory::toEntity).collect(Collectors.toList());
        assertNotNull(resultEmployees);
        assertEquals(employee1, resultEmployees.get(0));
        assertNotEquals(employee3, resultEmployees.get(1));


    }

    @Test
    void shouldDeleteEmployeeById() {
        //given
        employeeServiceMock.deleteEmployeeById(1L);
        //when - then
        verify(employeeRepository).deleteById(1L);

    }
}