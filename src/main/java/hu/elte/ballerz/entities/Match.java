package hu.elte.ballerz.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Match {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime created_at;
    
    @Column
    @UpdateTimestamp
    private LocalDateTime updated_at;
    
    @Column(nullable = false, length = 15)
    private String type;
    
    @Column(updatable = false)
    private LocalDateTime match_from;
    
    @Column(updatable = false)
    private LocalDateTime match_to;
    
    @Column(nullable = false)
    private Integer maximum_player_num;
    
    @Column(nullable = false)
    private Integer current_player_num;
    
    @ManyToMany(mappedBy = "matches")
    private Set<Player> players = new HashSet<>();
    
    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private Event event;
}
