package pl.luxmed.backendapp.service;

import org.springframework.stereotype.Service;
import pl.luxmed.backendapp.dto.EmployeeDto;
import pl.luxmed.backendapp.dto.EmployeeResourceFactory;
import pl.luxmed.backendapp.dto.SeekTextDto;
import pl.luxmed.backendapp.entity.Employee;
import pl.luxmed.backendapp.repository.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SeekService {

    private final EmployeeRepository employeeRepository;


    public SeekService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<EmployeeDto> getSeekListEmployees(SeekTextDto dto) {
        List<Employee> employees = employeeRepository.findAll();
        List<Employee> seekEmployees = new ArrayList<>();
        for (Employee e : employees) {
            boolean condition =
                    e.getFirstName().contains(dto.getSeekText()) ||
                    e.getLastName().contains(dto.getSeekText()) ||
                    e.getPesel().contains(dto.getSeekText()) ||
                    e.getSalary().toString().contains(dto.getSeekText());
            if(condition){
               seekEmployees.add(e);
            }
        }
        return seekEmployees.stream().map(EmployeeResourceFactory::fromEntity).collect(Collectors.toList());
    }
}
