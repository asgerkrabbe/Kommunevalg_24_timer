package com.kea.kommunevalg.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "parties")
public class Party {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String partyName;

    @Column(name = "votes", columnDefinition = "0")
    private long votes;

    @Column(name = "politician", nullable = false)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "party")
    Set<Politician> politicians;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }

    public long getVotes() {
        return votes;
    }

    public void setVotes(long votes) {
        this.votes = votes;
    }

    public Set<Politician> getPoliticians() {
        return politicians;
    }

    public void setPoliticians(Set<Politician> politicians) {
        this.politicians = politicians;
    }
}
