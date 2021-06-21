package izzi.ssorhh.users.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.*;

@Entity
@Table(name = "usuarios_rh")
public class UsuarioRH {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private long idSSFF;
    @Column(nullable = true, length = 128)
    private String nombre;
    @Column(nullable = true, length = 128)
    private String aPaterno;
    @Column(nullable = true, length = 128)
    private String aMaterno;
    private String nombreUsuario;
    private String email;
    private String password;
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date fecAlta;
    @Column(nullable = true)
    @Temporal(TemporalType.DATE)
    private Date fecBaja;
    @Column(length = 10)
    private String status;
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date fecReg;
    private long idRegSF;
    @Column(nullable = true, length = 150)
    private String comentarios;
    @NotNull
    @Column(length = 45)
    private String mtdoInicio;
    @NotNull
    @Column(length = 45)
    private String tpoUser;

    @NotNull
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tbl_usuario_rol",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "rol_id"))
    private Set<RolRH> roles = new HashSet<>();

    public UsuarioRH(){

    }

    public UsuarioRH(@NotNull long idSSFF, String nombre, String aPaterno, String aMaterno, String nombreUsuario, String email, String password, @NotNull Date fecAlta, Date fecBaja, String status, @NotNull Date fecReg, long idRegSF, String comentarios, @NotNull String mtdoInicio, @NotNull String tpoUser) {
        this.idSSFF = idSSFF;
        this.nombre = nombre;
        this.aPaterno = aPaterno;
        this.aMaterno = aMaterno;
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.password = password;
        this.fecAlta = fecAlta;
        this.fecBaja = fecBaja;
        this.status = status;
        this.fecReg = fecReg;
        this.idRegSF = idRegSF;
        this.comentarios = comentarios;
        this.mtdoInicio = mtdoInicio;
        this.tpoUser = tpoUser;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getIdSSFF() {
        return idSSFF;
    }

    public void setIdSSFF(long idSSFF) {
        this.idSSFF = idSSFF;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getaPaterno() {
        return aPaterno;
    }

    public void setaPaterno(String aPaterno) {
        this.aPaterno = aPaterno;
    }

    public String getaMaterno() {
        return aMaterno;
    }

    public void setaMaterno(String aMaterno) {
        this.aMaterno = aMaterno;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getFecAlta() {
        return fecAlta;
    }

    public void setFecAlta(Date fecAlta) {
        this.fecAlta = fecAlta;
    }

    public Date getFecBaja() {
        return fecBaja;
    }

    public void setFecBaja(Date fecBaja) {
        this.fecBaja = fecBaja;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getFecReg() {
        return fecReg;
    }

    public void setFecReg(Date fecReg) {
        this.fecReg = fecReg;
    }

    public long getIdRegSF() {
        return idRegSF;
    }

    public void setIdRegSF(long idRegSF) {
        this.idRegSF = idRegSF;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public String getMtdoInicio() {
        return mtdoInicio;
    }

    public void setMtdoInicio(String mtdoInicio) {
        this.mtdoInicio = mtdoInicio;
    }

    public String getTpoUser() {
        return tpoUser;
    }

    public void setTpoUser(String tpoUser) {
        this.tpoUser = tpoUser;
    }

    public Set<RolRH> getRoles() {
        return roles;
    }

    public void setRoles(Set<RolRH> roles) {
        this.roles = roles;
    }

}
