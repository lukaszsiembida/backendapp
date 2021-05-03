package pl.luxmed.backendapp.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import pl.luxmed.backendapp.dto.DepartmentDto;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "DEPARTMENT")
@Data
@NoArgsConstructor
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DEPARTMENT_ID")
    private Long departmentId;
    @Column(name = "DEPARTMENT_NAME", unique = true)
    private  String departmentName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "department", orphanRemoval = true, cascade = {CascadeType.REMOVE})
    private List<Employee> employees;

    public Department(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return departmentName.equals(that.departmentName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departmentName);
    }
}
