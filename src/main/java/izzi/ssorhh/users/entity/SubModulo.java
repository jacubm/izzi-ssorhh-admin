package izzi.ssorhh.users.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 * 
 * Clase que contiene los atributos de la tabla <code>tbl_sub_modulos</code>
 * para el almacenamiento de la informaci&oacute;n de los roles existentes para
 * el aplicativo
 * 
 * @author Jonathan David Reyes Ponce
 * @author <a href="http://www.adbansys.com/" target="_blank">Adbanys</a>
 * 
 * @see Entity
 * @see Table
 * @see Id
 * @see GeneratedValue
 * @see Column
 * @see PrePersist
 * @see NotNull
 *
 */
@Entity
@Table(name = "tbl_sub_modulos")
public class SubModulo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSubMod;
	@Column(name = "create_date", nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;
	@Column(nullable = true, length = 25)
	private String user;
	@Column(nullable = false, length = 50)
	private String modulo;
	@Column(nullable = true)
	private Integer estatus;
	@Column(nullable = false, length = 150)
	private String description;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_gpo")
	private Grupos grupo;

	@PrePersist
	public void generateDateDefault() {
		this.createDate = new Date();
	}

	/**
	 * @return the idSubMod
	 */
	public int getIdSubMod() {
		return idSubMod;
	}

	/**
	 * @param idSubMod the idSubMod to set
	 */
	public void setIdSubMod(int idSubMod) {
		this.idSubMod = idSubMod;
	}

	/**
	 * @return the createDate
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * @param createDate the createDate to set
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * @return the user
	 */
	public String getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(String user) {
		this.user = user;
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the grupo
	 */
	public Grupos getGrupo() {
		return grupo;
	}

	/**
	 * @param grupo the grupo to set
	 */
	public void setGrupo(Grupos grupo) {
		this.grupo = grupo;
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
}
