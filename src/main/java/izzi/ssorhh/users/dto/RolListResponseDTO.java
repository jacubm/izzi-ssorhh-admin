package izzi.ssorhh.users.dto;

import java.util.Set;

public class RolListResponseDTO extends BaseResponseDTO {

	private Set<RolDTO> listaRoles;

	public Set<RolDTO> getListaRoles() {
		return listaRoles;
	}

	public void setListaRoles(Set<RolDTO> listaRoles) {
		this.listaRoles = listaRoles;
	}
}
