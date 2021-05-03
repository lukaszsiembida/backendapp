package pl.luxmed.backendapp.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.annotation.DirtiesContext;
import pl.luxmed.backendapp.dto.DepartmentDto;
import pl.luxmed.backendapp.dto.DepartmentResourceFactory;
import pl.luxmed.backendapp.entity.Department;
import pl.luxmed.backendapp.entity.Employee;
import pl.luxmed.backendapp.repository.DepartmentRepository;
import pl.luxmed.backendapp.repository.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;


@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
//czysci kontekst aplikacji, uruchamia ją od nowa
@ExtendWith(MockitoExtension.class)
class DepartmentServiceTest {

    @Mock(lenient = true)
    private DepartmentRepository departmentRepository;

    @Mock(lenient = true)
    private EmployeeRepository employeeRepository;

    private DepartmentService departmentServiceMock;

    private Department department1;
    private Department department2;
    private String departmentName1;
    private String departmentName2;
    private Employee employee1;

    @BeforeEach
    public void setUp() {
        departmentServiceMock = new DepartmentService(departmentRepository, employeeRepository);
        MockitoAnnotations.initMocks(departmentServiceMock);

        departmentName1 = "IT";
        departmentName1 = "HR";
        department1 = new Department(departmentName1);
        department2 = new Department(departmentName2);
        employee1 = new Employee("Jan", "Nowak", "94031400942", 3200.00, department1);
    }


    @Test
    void shouldAddDepartment() {
        //given
        DepartmentDto dto = DepartmentResourceFactory.fromEntity(department1);

        //when
        //then
        when(departmentRepository.save(department1)).thenReturn(department1);
        Department resultDepartment = DepartmentResourceFactory.toEntity(departmentServiceMock.addDepartment(dto));
        assertNotNull(resultDepartment);
        assertEquals(department1, resultDepartment);
    }

    @Test
    void shouldSaveDepartment() {
        //given
        //when //then
        when(departmentRepository.save(department1)).thenReturn(department1);
        Department resultDepartment = departmentServiceMock.saveDepartment(department1.getDepartmentName());
        assertNotNull(resultDepartment);
        assertEquals(department1, resultDepartment);

    }


    @Test
    void shouldGetDepartments() {
        //given
        List<Department> departments = new ArrayList<>();
        departments.add(department1);
        //when
        //then
        when(departmentRepository.findAll()).thenReturn(departments);
        List<Department> resultDepartments = departmentServiceMock.getDepartments().stream()
                .map(DepartmentResourceFactory::toEntity).collect(Collectors.toList());
        assertNotNull(resultDepartments);
        assertEquals(department1.getDepartmentId(), resultDepartments.get(0).getDepartmentId());
        assertEquals(department1.getDepartmentName(), resultDepartments.get(0).getDepartmentName());
    }

    @Test
    void shouldFindByDepartmentName() {
        //given
        //when
        //then
        when(departmentRepository.findByDepartmentName(anyString())).thenReturn(department1);
        Department resultDepartment = departmentServiceMock.findByDepartmentName(departmentName1);
        assertNotNull(resultDepartment);
        assertEquals(departmentName1, resultDepartment.getDepartmentName());
    }

    @Test
    void shouldDeleteDepartmentById() {

        //given
        /*doNothing().when(departmentRepository).deleteById(department1.getDepartmentId());
        doNothing().when(employeeRepository.delete());

        departmentServiceMock.deleteDepartmentById(department1.getDepartmentId());*/
    }
}