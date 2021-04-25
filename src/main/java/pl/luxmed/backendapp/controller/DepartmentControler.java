package pl.luxmed.backendapp.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.luxmed.backendapp.entity.Department;
import pl.luxmed.backendapp.repository.DepartmentRepository;


@RestController
@RequestMapping("/department")
public class DepartmentControler {

    private final DepartmentRepository departmentRepository;

    public DepartmentControler(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @PostMapping("/add")
    Department addDepartment(@RequestBody Department department){
        return departmentRepository.save(department);
    }

}
