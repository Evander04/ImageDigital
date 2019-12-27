package jockercode.digital.digital.repository;

import jockercode.digital.digital.pojo.UserRoles;
import jockercode.digital.digital.pojo.Users;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface UserRolesRepository extends CrudRepository<UserRoles,Long> {

     List<UserRoles> findByUserId(Users s);

}
