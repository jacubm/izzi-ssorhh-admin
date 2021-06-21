package izzi.ssorhh.users.dto.response;

import java.util.Set;

import izzi.ssorhh.users.dto.AccionDTO;
import izzi.ssorhh.users.dto.BaseResponseDTO;

/**
 * <a href="https://en.wikipedia.org/wiki/JavaBeans" target="_blank">Java
 * Bean</a> especializado en el transporte
 * (<a href="https://en.wikipedia.org/wiki/Data_transfer_object" target=
 * "_blank">DTO</a>) de los datos de respuesta del servicio de listar todos las
 * <code><b>Acciones</b></code> existentes.
 *
 * @author Jonathan David Reyes Ponce
 * @author <a href="http://www.adbansys.com/" target="_blank">Adbanys</a>
 * 
 * @see Set
 * @see AccionDTO
 */
public class AccionListResponseDTO extends BaseResponseDTO {

	private Set<AccionDTO> listAccion;

	/**
	 * @return the listAccion
	 */
	public Set<AccionDTO> getListAccion() {
		return listAccion;
	}

	/**
	 * @param listAccion the listAccion to set
	 */
	public void setListAccion(Set<AccionDTO> listAccion) {
		this.listAccion = listAccion;
	}
}
