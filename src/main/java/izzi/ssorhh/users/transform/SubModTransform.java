package izzi.ssorhh.users.transform;

import java.text.SimpleDateFormat;

import izzi.ssorhh.users.dto.SubModuloDTO;
import izzi.ssorhh.users.dto.request.SubModuloRequestDTO;
import izzi.ssorhh.users.entity.Grupos;
import izzi.ssorhh.users.entity.SubModulo;

/**
 * Clase encarga de la tranformaci&oacute;n de un objeto a otro.
 * 
 * @author Jonathan David Reyes Ponce
 * @author <a href="http://www.adbansys.com/" target="_blank">Adbanys</a>
 * 
 * @see SubModuloRequestDTO
 * @see SubModulo
 *
 */
public class SubModTransform {

	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");


	public SubModulo parseDataObjetToEntity(SubModuloRequestDTO req, Grupos grupo) {
		SubModulo entity = new SubModulo();
		entity.setDescription(req.getComentarios());
		entity.setEstatus(req.getEstatus() == null ? 0 : req.getEstatus());
		entity.setGrupo(grupo);
		entity.setModulo(req.getModulo());
		entity.setUser(req.getUsuario() == null || req.getUsuario().isEmpty() ? null : req.getUsuario());
		return entity;
	}


	public SubModuloDTO parseDataEntotyToObject(SubModulo mod) {
		SubModuloDTO dto = new SubModuloDTO();
		dto.setDescripcion(mod.getDescription());
		dto.setEstatus(mod.getEstatus() == 1 ? "Activo" : "Inactivo");
		dto.setFechaAlta(simpleDateFormat.format(mod.getCreateDate()));
		dto.setId(mod.getIdSubMod());
		dto.setModulo(mod.getModulo());
		dto.setUsuario(mod.getUser());
		return dto;
	}
}
