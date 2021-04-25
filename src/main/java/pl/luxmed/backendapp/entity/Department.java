package pl.luxmed.backendapp.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long departmentId;
    @Column
    private  String departmentName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "department")
    private List<Employee> employees;

    public Department() {
    }

    public Department(String name, List<Employee> employees) {
        this.departmentName = name;
        this.employees = employees;
    }

}
