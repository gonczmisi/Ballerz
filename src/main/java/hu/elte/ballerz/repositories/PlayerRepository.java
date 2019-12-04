package hu.elte.ballerz.repositories;

import hu.elte.ballerz.entities.Player;
import org.springframework.data.repository.CrudRepository;

public interface PlayerRepository extends CrudRepository<Player, Integer> {
    
}