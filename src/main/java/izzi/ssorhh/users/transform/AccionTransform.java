package izzi.ssorhh.users.transform;

import java.text.SimpleDateFormat;

import izzi.ssorhh.users.dto.AccionDTO;
import izzi.ssorhh.users.dto.request.AccionRequestDTO;
import izzi.ssorhh.users.entity.Accion;

/**
 * Clase encarga de la tranformaci&oacute;n de un objeto a otro.
 * 
 * @author Jonathan David Reyes Ponce
 * @author <a href="http://www.adbansys.com/" target="_blank">Adbanys</a>
 * 
 * @see AccionDTO
 * @see Accion
 *
 */
public class AccionTransform {

	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");


	public Accion parseDataObjetToEntity(AccionRequestDTO req) {
		Accion entity = new Accion();
		entity.setAccion(req.getAccion());
		entity.setUser(req.getUsuario() == null || req.getUsuario().isEmpty() ? null : req.getUsuario());
		entity.setEstatus(req.getEstatus() == null ? 0 : req.getEstatus());
		entity.setDescription(
				req.getComentarios() == null || req.getComentarios().isEmpty() ? null : req.getComentarios());
		return entity;
	}

	public AccionDTO parseDataEntotyToObject(Accion acc) {
		AccionDTO dto = new AccionDTO();
		dto.setAccion(acc.getAccion());
		dto.setDescripcion(acc.getDescription());
		dto.setEstatus(acc.getEstatus() == 1 ? "Activo" : "Inactivo");
		dto.setFechaAlta(simpleDateFormat.format(acc.getCreateDate()));
		dto.setUsuario(acc.getUser());
		dto.setId(acc.getIdAcc());
		return dto;
	}

}
