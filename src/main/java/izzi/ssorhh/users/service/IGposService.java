package izzi.ssorhh.users.service;

import java.util.Optional;

import izzi.ssorhh.users.dto.GrupoDTO;
import izzi.ssorhh.users.dto.GrupoListResponseDTO;
import izzi.ssorhh.users.dto.GrupoResponseDTO;
import izzi.ssorhh.users.entity.Grupos;
import izzi.ssorhh.users.security.enums.GpoNombre;


public interface IGposService {
	Optional<Grupos> findByGposNombre(GpoNombre gpoNombre);
	GrupoResponseDTO save(GrupoDTO grupos);
	GrupoResponseDTO update(GrupoDTO grupos, Integer id);
	GrupoResponseDTO delete(Integer id);
	GrupoListResponseDTO getAll();
	GrupoResponseDTO getGruopById(Integer id);
}
