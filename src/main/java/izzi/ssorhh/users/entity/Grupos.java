package izzi.ssorhh.users.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "tbl_gpos_rh")
public class Grupos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idGpo;
	@Column(nullable = false, length = 25)
	private String gpoNombre;
	@Column(nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;
	@Column(nullable = true, length = 25)
	private String user;
	@Column(nullable = false, length = 150)
	private String description;
	@Column(nullable = true)
	private Integer estatus;

	@JsonIgnoreProperties(value = { "grupo" }, allowSetters = true)
	@OneToMany(mappedBy = "grupo", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<SubModulo> subModulos;


	@PrePersist
	public void generateDateDefault() {
		this.createDate = new Date();
	}

	public Grupos() {

	}

	public Grupos(@NotNull String gpoNombre) {
		super();
		this.gpoNombre = gpoNombre;
	}

	public int getIdGpo() {
		return idGpo;
	}

	public void setIdGpo(int idGpo) {
		this.idGpo = idGpo;
	}

	public String getGpoNombre() {
		return gpoNombre;
	}

	public void setGpoNombre(String gpoNombre) {
		this.gpoNombre = gpoNombre;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getEstatus() {
		return estatus;
	}

	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}

}
