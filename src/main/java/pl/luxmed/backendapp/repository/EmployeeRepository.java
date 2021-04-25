package pl.luxmed.backendapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import pl.luxmed.backendapp.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
