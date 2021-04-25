package pl.luxmed.backendapp.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DepartmentDto {

    private final Long departmentId;
    private final String departmentName;


}
