package hu.elte.ballerz.entities;

import javax.persistence.Enumerated;;

import hu.elte.ballerz.utils.PlayerPosition;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;

import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Player extends User {
    
    @ManyToMany
    @JoinTable(name = "statistics", joinColumns = {@JoinColumn(name = "player_id")}, inverseJoinColumns = {@JoinColumn(name = "match_id")})
    private Set<Match> matches = new HashSet<>();
    
    @Column(nullable = false, length = 15)
    @Enumerated(EnumType.STRING)
    private PlayerPosition position;
}