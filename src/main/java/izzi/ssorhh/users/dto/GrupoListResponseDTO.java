package izzi.ssorhh.users.dto;

import java.util.Set;

public class GrupoListResponseDTO extends BaseResponseDTO {

	private Set<GrupoDTO> listaGrupos;
	public Set<GrupoDTO> getListaGrupos() {
		return listaGrupos;
	}
	public void setListaGrupos(Set<GrupoDTO> listaGrupos) {
		this.listaGrupos = listaGrupos;
	}
}
