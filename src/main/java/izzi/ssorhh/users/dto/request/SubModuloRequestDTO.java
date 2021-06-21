package izzi.ssorhh.users.dto.request;

/**
 * <a href="https://en.wikipedia.org/wiki/JavaBeans" target="_blank">Java
 * Bean</a> especializado en el transporte
 * (<a href="https://en.wikipedia.org/wiki/Data_transfer_object" target=
 * "_blank">DTO</a>) de los datos de entrada del servicio de persistir un
 * <code><b>Sub M&oacute;dulo</b></code> en la base de datos.
 *
 * @author Jonathan David Reyes Ponce
 * @author <a href="http://www.adbansys.com/" target="_blank">Adbanys</a>
 * 
 * @see BaseRequestDTO
 */
public class SubModuloRequestDTO extends BaseRequestDTO {

	private Integer idGrupo;
	private String modulo;
	private Integer estatus;
	private String comentarios;

	/**
	 * @return the idGrupo
	 */
	public Integer getIdGrupo() {
		return idGrupo;
	}

	/**
	 * @param idGrupo the idGrupo to set
	 */
	public void setIdGrupo(Integer idGrupo) {
		this.idGrupo = idGrupo;
	}

	/**
	 * @return the modulo
	 */
	public String getModulo() {
		return modulo;
	}

	/**
	 * @param modulo the modulo to set
	 */
	public void setModulo(String modulo) {
		this.modulo = modulo;
	}

	/**
	 * @return the estatus
	 */
	public Integer getEstatus() {
		return estatus;
	}

	/**
	 * @param estatus the estatus to set
	 */
	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}

	/**
	 * @return the comentarios
	 */
	public String getComentarios() {
		return comentarios;
	}

	/**
	 * @param comentarios the comentarios to set
	 */
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
}
