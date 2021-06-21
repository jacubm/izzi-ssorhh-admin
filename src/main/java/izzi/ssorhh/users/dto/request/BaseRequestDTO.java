package izzi.ssorhh.users.dto.request;

import java.text.SimpleDateFormat;

/**
 * <a href="https://en.wikipedia.org/wiki/JavaBeans" target="_blank">Java
 * Bean</a> especializado en el transporte
 * (<a href="https://en.wikipedia.org/wiki/Data_transfer_object" target=
 * "_blank">DTO</a>) de los datos genricos de entrada.
 *
 * @author Jonathan David Reyes Ponce
 * @author <a href="http://www.adbansys.com/" target="_blank">Adbanys</a>
 * 
 * @see String
 * 
 */
public abstract class BaseRequestDTO {

	private String usuario;

	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
}
