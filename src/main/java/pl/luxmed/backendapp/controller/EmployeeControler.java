package pl.luxmed.backendapp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.luxmed.backendapp.dto.EmployeeDto;
import pl.luxmed.backendapp.entity.Employee;
import pl.luxmed.backendapp.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeControler {

    private final EmployeeService employeeService;

    public EmployeeControler(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/add")
    ResponseEntity<EmployeeDto> addOrEditEmployee(@RequestBody EmployeeDto dto) {
     return ResponseEntity.ok(employeeService.addOrEditEmployee(dto));
    }

    @GetMapping
    ResponseEntity<List<EmployeeDto>> getListEmployees() {
        return ResponseEntity.ok(employeeService.getListEmployees());
    }

    @GetMapping("/{departmentId}")
    ResponseEntity<List<EmployeeDto>> getListEmployeesWithDepartmentId(@PathVariable Long id){
        return ResponseEntity.ok(employeeService.getListEmployeesWithDepartmentId(id));
    }

    @DeleteMapping("/{employeeId}")
    ResponseEntity<Employee> deleteEmployee(@PathVariable Long employeeId) {
        employeeService.deleteEmployeeById(employeeId);
        return ResponseEntity.ok().build();
    }
}
