package pl.luxmed.backendapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.luxmed.backendapp.dto.DepartmentDto;
import pl.luxmed.backendapp.entity.Department;
import pl.luxmed.backendapp.service.DepartmentService;

import java.util.List;


@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping("/add")
    ResponseEntity<DepartmentDto> addDepartment(@RequestBody DepartmentDto dto) {
        return ResponseEntity.ok(departmentService.addDepartment(dto));
    }

    @GetMapping
    ResponseEntity<List<DepartmentDto>> getDepartments() {
        return ResponseEntity.ok(departmentService.getDepartments());
    }

    @DeleteMapping("/{departmentId}")
    String deleteDepartmentById(@PathVariable Long departmentId) {
        departmentService.deleteDepartmentById(departmentId);
        return "DELETED";
    }
}
