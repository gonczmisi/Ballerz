package hu.elte.ballerz.controllers;

import hu.elte.ballerz.entities.Statistics;
import hu.elte.ballerz.repositories.StatisticsRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/statistics")
public class StatisticsController {
    
    @Autowired
    private StatisticsRepository statisticsRepository;
    
    @GetMapping("")
    public ResponseEntity<Iterable<Statistics>> getAll() {
        return ResponseEntity.ok(statisticsRepository.findAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Statistics> get(@PathVariable Integer id) {
        Optional<Statistics> statistics = statisticsRepository.findById(id);
        if (statistics.isPresent()) {
            ResponseEntity.ok(statistics.get());
        }
        return ResponseEntity.notFound().build();
    }
    
    @PostMapping("")
    public ResponseEntity<Statistics> post(@RequestBody Statistics statistics) {
        Statistics savedStatistics = statisticsRepository.save(statistics);
        return ResponseEntity.ok(savedStatistics);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Statistics> put(@RequestBody Statistics statistics, @PathVariable Integer id) {
        Optional<Statistics> optionalStatistics = statisticsRepository.findById(id);
        if (optionalStatistics.isPresent()) {
            statistics.setMatchId(id);
            return ResponseEntity.ok(statisticsRepository.save(statistics));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        Optional<Statistics> optionalStatistics = statisticsRepository.findById(id);
        if (optionalStatistics.isPresent()) {
            statisticsRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}