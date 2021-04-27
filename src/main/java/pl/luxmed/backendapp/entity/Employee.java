package pl.luxmed.backendapp.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "EMPLOYEE")
@Data
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EMPLOYEE_ID")
    private Long employeeId;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name ="PESEL")
    private String pesel;
    @Column(name = "SALARY")
    private Double salary;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "departmentId")
    private Department department;

    public Employee(String firstName, String lastName, String pesel, Double salary, Department department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pesel = pesel;
        this.salary = salary;
        this.department = department;
    }

    public Employee(String firstName, String lastName, String pesel, Double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pesel = pesel;
        this.salary = salary;
    }

}
