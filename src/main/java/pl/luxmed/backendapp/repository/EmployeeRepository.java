package pl.luxmed.backendapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.luxmed.backendapp.entity.Employee;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("select p from Employee p where p.department.departmentId=?1")
    List<Employee> findAllByDepartmentId(Long id);


}
