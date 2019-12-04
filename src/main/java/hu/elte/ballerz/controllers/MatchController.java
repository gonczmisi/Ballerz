package hu.elte.ballerz.controllers;

import hu.elte.ballerz.entities.Match;
import hu.elte.ballerz.repositories.MatchRepository;
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
@RequestMapping("/matches")
public class MatchController {
    
    @Autowired
    private MatchRepository matchRepository;
    
    @GetMapping("")
    public ResponseEntity<Iterable<Match>> getAll() {
        return ResponseEntity.ok(matchRepository.findAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Match> get(@PathVariable Integer id) {
        Optional<Match> match = matchRepository.findById(id);
        if (match.isPresent()) {
            ResponseEntity.ok(match.get());
        }
        return ResponseEntity.notFound().build();
    }
    
    @PostMapping("")
    public ResponseEntity<Match> post(@RequestBody Match match) {
        Match savedMatch = matchRepository.save(match);
        return ResponseEntity.ok(savedMatch);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Match> put(@RequestBody Match match, @PathVariable Integer id) {
        Optional<Match> optionalMatch = matchRepository.findById(id);
        if (optionalMatch.isPresent()) {
            match.setId(id);
            return ResponseEntity.ok(matchRepository.save(match));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        Optional<Match> optionalMatch = matchRepository.findById(id);
        if (optionalMatch.isPresent()) {
            matchRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}