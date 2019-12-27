package jockercode.digital.digital.pojo;

import javax.persistence.*;

@Entity
@Table(name = "userBranch")
public class UserBranch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @OneToOne
    private Branch branch;
    @OneToOne
    private Users users;

    public UserBranch() {
    }

    public UserBranch(Branch branch, Users users) {
        this.branch = branch;
        this.users = users;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Branch getBranchId() {
        return branch;
    }

    public void setBranchId(Branch branchId) {
        this.branch = branchId;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "UserBranch{" +
                "Id=" + Id +
                ", branchId=" + branch +
                ", users=" + users +
                '}';
    }
}
