package pl.luxmed.backendapp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.luxmed.backendapp.entity.Employee;
import pl.luxmed.backendapp.repository.EmployeeRepository;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeControler {

    private final EmployeeRepository employeeRepository;

    public EmployeeControler(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @PostMapping
    Employee addEmployee(@RequestBody Employee employee){
       return employeeRepository.save(employee);
    }

    @GetMapping
    List<Employee> listEmployees(){
        return employeeRepository.findAll();
    }

    @DeleteMapping
    ResponseEntity<Employee> deleteEmployee(@RequestBody Long idEmployee){
        employeeRepository.deleteById(idEmployee);
        return ResponseEntity.ok().build();
    }


}
