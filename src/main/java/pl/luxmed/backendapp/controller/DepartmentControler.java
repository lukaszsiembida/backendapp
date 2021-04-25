package pl.luxmed.backendapp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.luxmed.backendapp.dto.DepartmentDto;
import pl.luxmed.backendapp.dto.DepartmentResourceFactory;
import pl.luxmed.backendapp.entity.Department;
import pl.luxmed.backendapp.repository.DepartmentRepository;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/departments")
public class DepartmentControler {

    private final DepartmentRepository departmentRepository;

    public DepartmentControler(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @PostMapping("/add")
    ResponseEntity<DepartmentDto> addDepartment(@RequestBody DepartmentDto dto) {
        Department department = departmentRepository.save(DepartmentResourceFactory.toEntity(dto));
        return ResponseEntity.ok(DepartmentResourceFactory.fromEntity(department));
    }

    @GetMapping
    ResponseEntity<List<DepartmentDto>> getDepartments() {
     List<DepartmentDto> departmentDtos = departmentRepository.findAll().stream().map(DepartmentResourceFactory::fromEntity).collect(Collectors.toList());
        return ResponseEntity.ok(departmentDtos);
    }


}
