package furama.furama.repository.employee;

import furama.furama.model.employee.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleRepository extends JpaRepository<AppRole,Long> {
}
