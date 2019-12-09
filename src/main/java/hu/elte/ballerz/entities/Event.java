package hu.elte.ballerz.entities;

import hu.elte.ballerz.utils.EventType;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
public class Event {
    
    @Id
    @Column(updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(nullable = true, updatable = false)
    @CreationTimestamp
    private LocalDateTime created_at;
    
    @Column(nullable = true)
    @UpdateTimestamp
    private LocalDateTime updated_at;
    
    @Column(nullable = false, length = 50)
    private String name;
    
    @Column(nullable = true, length = 15)
    @Enumerated(EnumType.STRING)
    private EventType type;
    
    @Column(nullable = false, length = 20)
    private String organizer;
    
    @Column(nullable = false, length = 40)
    private String venue;
    
    @Column(nullable = true)
    private LocalDateTime event_from;
    
    @Column(nullable = true)
    private LocalDateTime event_to;
    
    @Column(nullable = false)
    private Integer current_players;
    
    @OneToMany(mappedBy = "event")
    private List<Match> matches;
}