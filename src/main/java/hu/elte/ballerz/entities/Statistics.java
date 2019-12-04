package hu.elte.ballerz.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Statistics {
    
    @Id  
    private Integer match_id;
    
    private Integer player_id;
    
    @Column(nullable = false)
    private Integer goals;
    
    @Column(nullable = false)
    private Integer assists;
    
    @Column(nullable = false)
    private Integer conceded;

    public void setMatchId(Integer id) {
        this.match_id = id;
    }
}