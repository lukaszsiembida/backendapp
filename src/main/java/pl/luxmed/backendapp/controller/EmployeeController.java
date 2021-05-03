package pl.luxmed.backendapp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.luxmed.backendapp.dto.EmployeeDto;
import pl.luxmed.backendapp.entity.Employee;
import pl.luxmed.backendapp.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/add")
    ResponseEntity<EmployeeDto> addEmployee(@RequestBody EmployeeDto dto) {
     return ResponseEntity.ok(employeeService.addEmployee(dto));
    }

    @GetMapping
    ResponseEntity<List<EmployeeDto>> getListEmployees() {
        return ResponseEntity.ok(employeeService.getListEmployees());
    }

    @GetMapping("/{id}")
    ResponseEntity<List<EmployeeDto>> getListEmployeesWithDepartmentId(@PathVariable Long id){
        return ResponseEntity.ok(employeeService.getListEmployeesByDepartmentId(id));
    }

    @DeleteMapping("/{employeeId}")
    ResponseEntity<Employee> deleteEmployee(@PathVariable Long employeeId) {
        employeeService.deleteEmployeeById(employeeId);
        return ResponseEntity.ok().build();
    }
}
