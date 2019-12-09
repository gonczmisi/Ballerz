package hu.elte.ballerz.repositories;

import hu.elte.ballerz.entities.Event;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Event, Integer> {
    
    public Optional<Event> findByType(String type);
    
}