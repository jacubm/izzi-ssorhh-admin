package izzi.ssorhh.users.repository;

import izzi.ssorhh.users.entity.RolRH;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RolRHRepository extends JpaRepository<RolRH, Integer> {
    Optional<RolRH> findByRolNombre(String rolNombre);
    boolean existsByRolNombre(String rol);
    boolean existsById(Integer id);
}
