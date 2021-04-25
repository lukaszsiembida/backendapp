package pl.luxmed.backendapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import pl.luxmed.backendapp.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
