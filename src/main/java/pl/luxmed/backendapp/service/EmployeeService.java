package pl.luxmed.backendapp.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.luxmed.backendapp.dto.EmployeeDto;
import pl.luxmed.backendapp.dto.EmployeeResourceFactory;
import pl.luxmed.backendapp.entity.Department;
import pl.luxmed.backendapp.entity.Employee;
import pl.luxmed.backendapp.repository.EmployeeRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentService departmentService;

    public EmployeeDto addEmployee(EmployeeDto dto) {
        Department department;
        if(dto.getDepartmentName().equals("")){
            Employee employee = employeeRepository.save(EmployeeResourceFactory.toEntity(dto));
            return dto;
        }
        if(departmentService.findByDepartmentName(dto.getDepartmentName()).isEmpty()){
           department = departmentService.saveDepartment(dto.getDepartmentName());
        } else {
            department = departmentService.findByDepartmentName(dto.getDepartmentName()).stream().findFirst().get();
        }
        return EmployeeResourceFactory.fromEntity(employeeRepository.save(EmployeeResourceFactory.toEntity(dto, department)));
    }

    public List<EmployeeDto> getListEmployees() {
        return employeeRepository.findAll().stream().map(EmployeeResourceFactory::fromEntity).collect(Collectors.toList());
    }

    public List<EmployeeDto> getListEmployeesWithDepartmentId(Long id) {
        return employeeRepository.findAllByDepartmentId(id).stream().map(EmployeeResourceFactory::fromEntity).collect(Collectors.toList());
    }

    public void deleteEmployeeById(Long employeeId) {
        employeeRepository.deleteById(employeeId);
    }

}
