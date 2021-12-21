package com.kea.kommunevalg.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "parties")
public class Party {

    @Id
    @Column(name = "party_id", updatable = false, insertable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "votes", columnDefinition = "0")
    private long votes;

    @JsonIgnore
    @OneToMany()
    @JoinColumn(name = "party_id")
    private Set<Politician> politicians;

    public Party(Long id, String name, long votes, Set<Politician> politicians) {
        this.id = id;
        this.name = name;
        this.votes = votes;
        this.politicians = politicians;
    }

    public Party() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String partyName) {
        this.name = partyName;
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
