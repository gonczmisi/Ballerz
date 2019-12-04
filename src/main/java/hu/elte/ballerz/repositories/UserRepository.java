package hu.elte.ballerz.repositories;

import hu.elte.ballerz.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
    
}