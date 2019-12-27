package jockercode.digital.digital.repository;

import jockercode.digital.digital.pojo.Users;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Users,Long> {
    Users findByUsername(String username);
}
