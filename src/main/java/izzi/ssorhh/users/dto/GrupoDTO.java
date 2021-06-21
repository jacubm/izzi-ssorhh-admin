package izzi.ssorhh.users.dto;

public class GrupoDTO implements Comparable<GrupoDTO> {

	private Integer id;
	private String grupo;
	private String descripcion;
	private String estatus;
	private String usuario;
	private String fecheAlta;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	@Override
	public int compareTo(GrupoDTO other) {
		int compare = -1;
		if (other != null && other.getId() != null && this.getId() != null) {
			compare = this.getId().compareTo(other.getId());
		}
		return compare;
	}

	/**
	 * @return the fecheAlta
	 */
	public String getFecheAlta() {
		return fecheAlta;
	}

	/**
	 * @param fecheAlta the fecheAlta to set
	 */
	public void setFecheAlta(String fecheAlta) {
		this.fecheAlta = fecheAlta;
	}
}
