package hu.elte.ballerz.repositories;

import hu.elte.ballerz.entities.Statistics;
import org.springframework.data.repository.CrudRepository;

public interface StatisticsRepository extends CrudRepository<Statistics, Integer> {
    
}