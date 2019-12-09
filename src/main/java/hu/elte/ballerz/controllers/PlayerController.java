package hu.elte.ballerz.controllers;

import hu.elte.ballerz.entities.Player;
import hu.elte.ballerz.repositories.PlayerRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/players")
public class PlayerController {
    
    @Autowired
    private PlayerRepository playerRepository;
    
    @GetMapping("")
    public ResponseEntity<Iterable<Player>> getAll() {
        return ResponseEntity.ok(playerRepository.findAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Player> get(@PathVariable Integer id) {
        Optional<Player> player = playerRepository.findById(id);
        if (player.isPresent()) {
            ResponseEntity.ok(player.get());
        }
        return ResponseEntity.notFound().build();
    }
    
    @PostMapping("")
    public ResponseEntity<Player> post(@RequestBody Player player) {
        Player savedPlayer = playerRepository.save(player);
        return ResponseEntity.ok(savedPlayer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Player> put(@RequestBody Player player, @PathVariable Integer id) {
        Optional<Player> optionalPlayer = playerRepository.findById(id);
        if (optionalPlayer.isPresent()) {
            player.setId(id);
            return ResponseEntity.ok(playerRepository.save(player));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        Optional<Player> optionalPlayer = playerRepository.findById(id);
        if (optionalPlayer.isPresent()) {
            playerRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}