package pl.luxmed.backendapp.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.luxmed.backendapp.dto.EmployeeDto;
import pl.luxmed.backendapp.dto.EmployeeResourceFactory;
import pl.luxmed.backendapp.entity.Employee;
import pl.luxmed.backendapp.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeDto addOrEditEmployee(EmployeeDto dto) {
        if (dto.getEmployeeId() == null) {
            return EmployeeResourceFactory.fromEntity(employeeRepository.save(EmployeeResourceFactory.toEntity(dto)));
        } else {
            Optional<Employee> optionalEmployee = employeeRepository.findById(dto.getEmployeeId());
            if (optionalEmployee.isPresent()) {
                Employee employee = optionalEmployee.get();
                employee.updateEmployee(dto);
                return EmployeeResourceFactory.fromEntity(employeeRepository.save(employee));
            } else {
                throw new RuntimeException("Nie można znaleźć użytkownika z id: " + dto.getEmployeeId());
            }
        }
    }

    public List<EmployeeDto> getListEmployees() {
        return employeeRepository.findAll().stream().map(EmployeeResourceFactory::fromEntity).collect(Collectors.toList());
    }

    public List<EmployeeDto> getListEmployeesWithDepartmentId(Long id) {
        return employeeRepository.findAllByDepartmentId(id).stream().map(EmployeeResourceFactory::fromEntity).collect(Collectors.toList());
    }

    public void deleteEmployeeById(Long employeeId) {
        employeeRepository.deleteById(employeeId);
    }

}
