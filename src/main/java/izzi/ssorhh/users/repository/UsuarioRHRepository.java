package izzi.ssorhh.users.repository;

import izzi.ssorhh.users.entity.UsuarioRH;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRHRepository extends JpaRepository<UsuarioRH, Integer> {
    Optional<UsuarioRH> findByNombreUsuario(String nombreUsuario);
    boolean existsByNombreUsuario(String nombreUsuario);
    boolean existsByEmail(String email);
}
