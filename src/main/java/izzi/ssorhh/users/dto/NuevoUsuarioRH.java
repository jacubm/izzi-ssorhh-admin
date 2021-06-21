package izzi.ssorhh.users.dto;

import izzi.ssorhh.users.entity.RolRH;

import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


public class NuevoUsuarioRH {
    private long idSSFF;
    @NotBlank
    private String nombre;
    @NotBlank
    private String aPaterno;
    @NotBlank
    private String aMaterno;
    private String nombreUsuario;
    private String email;
    private String password;
    private Date fecAlta;
    private Date fecBaja;
    private String status;
    private Date fecReg;
    private long idRegSF;
    private String comentarios;
    private String mtdoInicio;
    private String tpoUser;

    private Set<String> roles = new HashSet<>();


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

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

}
