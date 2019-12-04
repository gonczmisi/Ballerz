package hu.elte.ballerz.repositories;

import hu.elte.ballerz.entities.Event;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Event, Integer> {
    
}