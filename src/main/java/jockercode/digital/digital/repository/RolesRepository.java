package jockercode.digital.digital.repository;


import jockercode.digital.digital.pojo.Role;
import org.springframework.data.repository.CrudRepository;

public interface RolesRepository extends CrudRepository<Role,Long> {
    Role findByName(String name);
}
