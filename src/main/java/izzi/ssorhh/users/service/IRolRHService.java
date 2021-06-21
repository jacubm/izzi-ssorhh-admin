package izzi.ssorhh.users.service;

import izzi.ssorhh.users.dto.RolDTO;
import izzi.ssorhh.users.dto.RolListResponseDTO;
import izzi.ssorhh.users.dto.RolResponseDTO;
import izzi.ssorhh.users.entity.RolRH;
import java.util.Optional;

public interface IRolRHService {
    Optional<RolRH> getByRolNombre(String rolNombre);
    RolResponseDTO delete(Integer id);
    RolResponseDTO save(RolDTO rol);
    RolResponseDTO update(RolDTO rol, Integer id);
    Optional<RolRH> getOne(Integer id);
    RolListResponseDTO list();
}
