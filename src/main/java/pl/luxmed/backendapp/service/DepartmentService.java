package pl.luxmed.backendapp.service;

import org.springframework.stereotype.Service;
import pl.luxmed.backendapp.dto.DepartmentDto;
import pl.luxmed.backendapp.dto.DepartmentResourceFactory;
import pl.luxmed.backendapp.entity.Department;
import pl.luxmed.backendapp.repository.DepartmentRepository;
import pl.luxmed.backendapp.repository.EmployeeRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;

    public DepartmentService(DepartmentRepository departmentRepository, EmployeeRepository employeeRepository) {
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
    }

    public DepartmentDto addDepartment(DepartmentDto dto) {
        Department department = departmentRepository.save(DepartmentResourceFactory.toEntity(dto));
        return DepartmentResourceFactory.fromEntity(department);
    }

    public Department saveDepartment(String name) {
        Department department = new Department(name);
        return departmentRepository.save(department);
    }


    public List<DepartmentDto> getDepartments() {
        return departmentRepository.findAll().stream().map(DepartmentResourceFactory::fromEntity).collect(Collectors.toList());
    }

    public Department findByDepartmentName(String departmentName) {
        return departmentRepository.findByDepartmentName(departmentName);
    }

    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

}
