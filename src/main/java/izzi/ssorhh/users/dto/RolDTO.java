package izzi.ssorhh.users.dto;

public class RolDTO implements Comparable<RolDTO> {

	private Integer id;
	private String rol;
	private String descripcion;
	private String estatus;
	private String usuario;
	private String fechaAlta;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
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

	@Override
	public int compareTo(RolDTO other) {
		int compare = -1;
		if (other != null && other.getId() != null && this.getId() != null) {
			compare = this.getId().compareTo(other.getId());
		}
		return compare;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(String fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
}
