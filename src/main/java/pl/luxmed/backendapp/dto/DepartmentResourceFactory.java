package pl.luxmed.backendapp.dto;

import pl.luxmed.backendapp.entity.Department;

public class DepartmentResourceFactory {

    public static Department toEntity(DepartmentDto dto) {
        return new Department(dto.getDepartmentName());
    }

    public static DepartmentDto fromEntity(Department department) {
        return new DepartmentDto(department.getDepartmentId(), department.getDepartmentName());
    }

}
