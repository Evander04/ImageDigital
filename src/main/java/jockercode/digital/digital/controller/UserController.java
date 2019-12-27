package jockercode.digital.digital.controller;


import jockercode.digital.digital.pojo.UserRoles;
import jockercode.digital.digital.pojo.Users;
import jockercode.digital.digital.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserController {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private UserRoleController urController;

    @Autowired
    private RoleController roleController;

    public Users save(Users s){
        BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
        s.setPassword(encoder.encode(s.getPassword()));
        userRepo.save(s);
        s.getRole().forEach(r->{
            urController.save( new UserRoles(s,roleController.getByRole(r),true));
        });
        return s;
    }

    public Users getByUser(String username){
        Users user=userRepo.findByUsername(username);
        if (user!=null){
            List<String> roles=new ArrayList<>();
            urController.getRolesByUser(user).forEach(r->{
                roles.add(r.getRoleId().getName());
            });
            user.setRole(roles);
        }
        return user;
    }

}
