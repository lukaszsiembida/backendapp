package pl.luxmed.backendapp.dto;


import pl.luxmed.backendapp.entity.Department;
import pl.luxmed.backendapp.entity.Employee;

public class EmployeeResourceFactory {

    public static Employee toEntity(EmployeeDto dto, Department department) {
        return new Employee(
                dto.getFirstName(),
                dto.getLastName(),
                dto.getPesel(),
                dto.getSalary(),
                department);
    }

    public static  Employee toEntity(EmployeeDto dto){
        return new Employee(
          dto.getFirstName(),
                dto.getLastName(),
                dto.getPesel(),
                dto.getSalary(),
                new Department(dto.getDepartmentName())
        );
    }

    public static EmployeeDto fromEntity(Employee employee) {
        return new EmployeeDto(
                employee.getEmployeeId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getPesel(),
                employee.getSalary(),
                employee.getDepartment().getDepartmentName()
        );
    }
}
