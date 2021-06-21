package izzi.ssorhh.users.dto.response;

import izzi.ssorhh.users.dto.AccionDTO;
import izzi.ssorhh.users.dto.BaseResponseDTO;

/**
 * <a href="https://en.wikipedia.org/wiki/JavaBeans" target="_blank">Java
 * Bean</a> especializado en el transporte
 * (<a href="https://en.wikipedia.org/wiki/Data_transfer_object" target=
 * "_blank">DTO</a>) de los datos de respuesta del servicio de encontrar una
 * <code><b>Acci&oacute;n</b></code> existente.
 *
 * @author Jonathan David Reyes Ponce
 * @author <a href="http://www.adbansys.com/" target="_blank">Adbanys</a>
 * 
 * @see AccionDTO
 */
public class AccionResponseDTO extends BaseResponseDTO {

	private AccionDTO accion;

	/**
	 * @return the accion
	 */
	public AccionDTO getAccion() {
		return accion;
	}

	/**
	 * @param accion the accion to set
	 */
	public void setAccion(AccionDTO accion) {
		this.accion = accion;
	}
}
