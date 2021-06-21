package izzi.ssorhh.users.transform;

import java.text.SimpleDateFormat;

import izzi.ssorhh.users.dto.RolDTO;
import izzi.ssorhh.users.entity.RolRH;

public class RolTransform {

	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");


	public RolDTO parseDataEntityToObject(RolRH rolRH) {
		RolDTO resp = new RolDTO();
		resp.setDescripcion(rolRH.getDescription());
		resp.setEstatus(rolRH.isEstatus() ? "Activo" : "Inactivo");
		resp.setId(rolRH.getId());
		resp.setUsuario(rolRH.getUser());
		resp.setRol(rolRH.getRolNombre());
		resp.setFechaAlta(simpleDateFormat.format(rolRH.getCreateDate()));
		return resp;
	}

	public RolRH parseDataEntityToObject(RolDTO rol) {
		RolRH resp = new RolRH();
		resp.setDescription(rol.getDescripcion());
		resp.setEstatus(rol.getEstatus() == null || rol.getEstatus().isEmpty() ? false
				: rol.getEstatus().equalsIgnoreCase("Activo") ? true : false);
		resp.setRolNombre(rol.getRol());
		resp.setUser(rol.getUsuario() == null || rol.getUsuario().isEmpty() ? null : rol.getUsuario());
		return resp;
	}
}
