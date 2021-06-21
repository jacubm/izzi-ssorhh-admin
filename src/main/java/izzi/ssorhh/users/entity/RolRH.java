package izzi.ssorhh.users.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="roles_rh")
public class RolRH {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private String rolNombre;

    @NotNull
    @Column(nullable = false, length = 150)
    private String description;

    @Column(nullable = true, length = 25)
    private String user;

    @Column(name = "create_date", nullable = true)
    @Temporal(TemporalType.DATE)
    private Date createDate;

    @Column(nullable = true)
    private boolean estatus;


    @PrePersist
    public void generateDateDefault() {
        this.createDate = new Date();
    }

    public RolRH(){

    }

    public RolRH(@NotNull String rolNombre) {
        this.rolNombre = rolNombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRolNombre() {
        return rolNombre;
    }

    public void setRolNombre(String rolNombre) {
        this.rolNombre = rolNombre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public boolean isEstatus() {
        return estatus;
    }

    public void setEstatus(boolean estatus) {
        this.estatus = estatus;
    }

}
