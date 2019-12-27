package jockercode.digital.digital.controller;

import jockercode.digital.digital.pojo.UserRoles;
import jockercode.digital.digital.pojo.Users;
import jockercode.digital.digital.repository.UserRolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleController {
    @Autowired
    private UserRolesRepository urRepo;

    public List<UserRoles> getRolesByUser(Users user){
        return urRepo.findByUserId(user);
    }

    public UserRoles save(UserRoles ur){
        return urRepo.save(ur);
    }
}
