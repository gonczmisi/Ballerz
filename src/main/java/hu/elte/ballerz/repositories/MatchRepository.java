package hu.elte.ballerz.repositories;

import hu.elte.ballerz.entities.Match;
import org.springframework.data.repository.CrudRepository;

public interface MatchRepository extends CrudRepository<Match, Integer> {
    
}