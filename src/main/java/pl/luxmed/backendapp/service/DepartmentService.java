package pl.luxmed.backendapp.service;

import org.springframework.stereotype.Service;
import pl.luxmed.backendapp.dto.DepartmentDto;
import pl.luxmed.backendapp.dto.DepartmentResourceFactory;
import pl.luxmed.backendapp.entity.Department;
import pl.luxmed.backendapp.repository.DepartmentRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
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

    public List<Department> findByDepartmentName(String departmentName) {
        return departmentRepository.findByDepartmentName(departmentName);
    }

    @Transactional
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.findByDepartmentId(departmentId).getEmployees().forEach(e -> e.setDepartment(null));
        departmentRepository.deleteById(departmentId);
    }
}
