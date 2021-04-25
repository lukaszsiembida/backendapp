package pl.luxmed.backendapp.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "DEPARTMENT")
@Data
@NoArgsConstructor
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "DEPARTMENT_ID")
    private Long departmentId;
    @Column(name = "DEPARTMENT_NAME")
    private  String departmentName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "department")
    private List<Employee> employees;

    public Department(String name, List<Employee> employees) {
        this.departmentName = name;
        this.employees = employees;
    }

    public Department(String departmentName) {
        this.departmentName = departmentName;
    }
}
