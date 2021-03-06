package academy.everyonecodes.java.data.repositories;

import academy.everyonecodes.java.data.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRole(String role);

    List<Role> findAll();
}
