package jockercode.digital.digital.controller;

;
import jockercode.digital.digital.pojo.Role;
import jockercode.digital.digital.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleController {

    @Autowired
    private RolesRepository rRepo;

    public Role getById(Long id){
        return rRepo.findById(id).get();
    }

    public Role getByRole(String name){ return  rRepo.findByName(name);}
}
