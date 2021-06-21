package izzi.ssorhh.users.service;

import izzi.ssorhh.users.entity.UsuarioRH;

import java.util.List;
import java.util.Optional;

public interface IUsuariosRHService {
    List<UsuarioRH> list();
    Optional<UsuarioRH> getByNombreUsuario(String nombreUsuario);
    boolean existsById(int id);
    Optional<UsuarioRH> getOne(int id);
    boolean existsByNombreUsuario(String nombreUsuario);
    boolean existsByEmail(String email);
    void save(UsuarioRH userrh);
    void delete(int id);
}
