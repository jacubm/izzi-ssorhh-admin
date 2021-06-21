package izzi.ssorhh.users.dto;

/**
 * <a href="https://en.wikipedia.org/wiki/JavaBeans" target="_blank">Java
 * Bean</a> especializado en el transporte
 * (<a href="https://en.wikipedia.org/wiki/Data_transfer_object" target=
 * "_blank">DTO</a>) de los datos de respuesta de un
 * <code><b>Sub M&oacute;dulo</b></code>.
 *
 * @author Jonathan David Reyes Ponce
 * @author <a href="http://www.adbansys.com/" target="_blank">Adbanys</a>
 * 
 * @see Comparable
 * @see Integer
 * @see String
 * @see Boolean
 */
public class SubModuloDTO implements Comparable<SubModuloDTO> {

	private Integer id;
	private String modulo;
	private String descripcion;
	private String estatus;
	private String usuario;
	private String fechaAlta;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
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
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the estatus
	 */
	public String getEstatus() {
		return estatus;
	}

	/**
	 * @param estatus the estatus to set
	 */
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

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

	/**
	 * @return the fechaAlta
	 */
	public String getFechaAlta() {
		return fechaAlta;
	}

	/**
	 * @param fechaAlta the fechaAlta to set
	 */
	public void setFechaAlta(String fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	@Override
	public int compareTo(SubModuloDTO other) {
		int compare = -1;
		if (other != null && other.getId() != null && this.getId() != null) {
			compare = this.getId().compareTo(other.getId());
		}
		return compare;
	}

}
