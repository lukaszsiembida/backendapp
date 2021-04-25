package pl.luxmed.backendapp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.luxmed.backendapp.dto.EmployeeDto;
import pl.luxmed.backendapp.dto.EmployeeResourceFactory;
import pl.luxmed.backendapp.entity.Employee;
import pl.luxmed.backendapp.repository.EmployeeRepository;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/employees")
public class EmployeeControler {

    private final EmployeeRepository employeeRepository;

    public EmployeeControler(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @PostMapping("/add")
    EmployeeDto addEmployee(@RequestBody EmployeeDto dto) {
        Employee employee = employeeRepository.save(EmployeeResourceFactory.toEntity(dto));
        return EmployeeResourceFactory.fromEntity(employee);
    }

    @GetMapping
    List<EmployeeDto> listEmployees() {
        return employeeRepository.findAll().stream().map(EmployeeResourceFactory::fromEntity).collect(Collectors.toList());
    }

    @DeleteMapping
    ResponseEntity<Employee> deleteEmployee(@RequestBody Long idEmployee) {
        employeeRepository.deleteById(idEmployee);
        return ResponseEntity.ok().build();
    }


}
