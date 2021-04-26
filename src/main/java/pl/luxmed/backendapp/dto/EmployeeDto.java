package pl.luxmed.backendapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class EmployeeDto {

    private final Long employeeId;
    private final String firstName;
    private final String lastName;
    private final String pesel;
    private final Double salary;
    private final String departmentName;

}
