package furama.furama.repository.employee;

import furama.furama.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee,Integer> {

    @Query(value = "select * from employee where name like :name",nativeQuery = true)
    List<Employee> findByName(String name);


    @Query(value = "select * from employee where name like :name",nativeQuery = true)
    Page<Employee> findByNamePage(@Param("name") String nameNew, Pageable pageable);
}
