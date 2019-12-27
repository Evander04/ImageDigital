package jockercode.digital.digital.pojo;

import javax.persistence.*;

@Entity
@Table(name = "UserRoles")
public class UserRoles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "USERS_ROLES_SEQ")
    @SequenceGenerator(name = "USERS_ROLES_SEQ", sequenceName = "USERS_ROLES_SEQ", allocationSize = 1,initialValue = 2)
    private Long id;
    @OneToOne
    private Users userId;
    @OneToOne
    private Role roleId;
    private Boolean status;

    public UserRoles() {
    }

    public UserRoles(Users userId, Role roleId, Boolean status) {
        this.userId = userId;
        this.roleId = roleId;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Users getUserId() {
        return userId;
    }

    public void setUserId(Users userId) {
        this.userId = userId;
    }

    public Role getRoleId() {
        return roleId;
    }

    public void setRoleId(Role roleId) {
        this.roleId = roleId;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
