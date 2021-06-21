package izzi.ssorhh.users.dto.response;

import java.util.Set;

import izzi.ssorhh.users.dto.BaseResponseDTO;
import izzi.ssorhh.users.dto.SubModuloDTO;

/**
 * <a href="https://en.wikipedia.org/wiki/JavaBeans" target="_blank">Java
 * Bean</a> especializado en el transporte
 * (<a href="https://en.wikipedia.org/wiki/Data_transfer_object" target=
 * "_blank">DTO</a>) de los datos de respuesta del servicio de listar todos los
 * <code><b>Sub M&oacute;dulos</b></code> existentes.
 *
 * @author Jonathan David Reyes Ponce
 * @author <a href="http://www.adbansys.com/" target="_blank">Adbanys</a>
 * 
 * @see Set
 * @see SubModuloDTO
 */
public class SubModuloListResponseDTO extends BaseResponseDTO {

	private Set<SubModuloDTO> listSubModulos;

	/**
	 * @return the listSubModulos
	 */
	public Set<SubModuloDTO> getListSubModulos() {
		return listSubModulos;
	}

	/**
	 * @param listSubModulos the listSubModulos to set
	 */
	public void setListSubModulos(Set<SubModuloDTO> listSubModulos) {
		this.listSubModulos = listSubModulos;
	}

}
