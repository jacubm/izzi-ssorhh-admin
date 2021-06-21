package izzi.ssorhh.users.security.repository;

import java.util.Optional;

import izzi.ssorhh.users.security.enums.RolNombre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import izzi.ssorhh.users.security.entity.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
	Optional<Rol> findByRolNombre(RolNombre rolNombre);
	boolean existsByRolNombre(String rol);
	boolean existsById(Integer id);
}
