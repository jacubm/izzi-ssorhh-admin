package izzi.ssorhh.users.transform;

import java.text.SimpleDateFormat;

import izzi.ssorhh.users.dto.GrupoDTO;
import izzi.ssorhh.users.entity.Grupos;

public class GrupoTransform {

	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

	public GrupoDTO parseDataEntityToObject(Grupos grupo) {
		GrupoDTO resp = new GrupoDTO();
		resp.setDescripcion(grupo.getDescription());
		resp.setEstatus(grupo.getEstatus() == 1 ? "Activo" : "Inactivo");
		resp.setId(grupo.getIdGpo());
		resp.setUsuario(grupo.getUser());
		resp.setGrupo(grupo.getGpoNombre());
		resp.setFecheAlta(simpleDateFormat.format(grupo.getCreateDate()));
		return resp;
	}

	public Grupos parseDataObjetToEntity(GrupoDTO grupo) {
		Grupos entity = new Grupos();
		entity.setDescription(grupo.getDescripcion());
		entity.setEstatus(grupo.getEstatus() == null || grupo.getEstatus().isEmpty() ? 0
				: grupo.getEstatus().equalsIgnoreCase("Activo") ? 1 : 0);
		entity.setGpoNombre(grupo.getGrupo());
		entity.setUser(grupo.getUsuario() == null || grupo.getUsuario().isEmpty() ? null : grupo.getUsuario());
		return entity;
	}
}
