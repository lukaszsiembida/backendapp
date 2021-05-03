package pl.luxmed.backendapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.luxmed.backendapp.entity.Department;

import java.util.List;
import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    @Query("select distinct p from Department p where upper(p.departmentName) like concat('%',upper(?1), '%')")
    Department findByDepartmentName(String query);

    Department findByDepartmentId (Long id);
}
