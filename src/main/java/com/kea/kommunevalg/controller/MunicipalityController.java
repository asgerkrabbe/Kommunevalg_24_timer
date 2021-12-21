package com.kea.kommunevalg.controller;

import com.kea.kommunevalg.model.Party;
import com.kea.kommunevalg.model.Politician;
import com.kea.kommunevalg.repository.PartyRepository;
import com.kea.kommunevalg.repository.PoliticianRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "*")
public class MunicipalityController {

    PartyRepository partyRep;
    PoliticianRepository politicianRep;

    public MunicipalityController(PartyRepository partyRep, PoliticianRepository politicianRep) {
        this.partyRep = partyRep;
        this.politicianRep = politicianRep;
    }

    @GetMapping("/parties")
    public ResponseEntity<List<Party>> findAllParties() {
        List<Party> parties = new ArrayList<>();
        partyRep.findAll().forEach(parties::add);
        return ResponseEntity.status(HttpStatus.OK).body(parties);
    }

    @GetMapping("/party/{id}")
    public ResponseEntity<Optional<Party>> findPartyById(@PathVariable Long id) {
        Optional<Party> optionalParty = partyRep.findById(id);

        return ResponseEntity.status(HttpStatus.OK).body(optionalParty);
    }

    @GetMapping("/politicians")
    public ResponseEntity<List<Politician>> findAllPoliticians() {
        List<Politician> politicians = new ArrayList<>();
        politicianRep.findAll().forEach(politicians::add);
        return ResponseEntity.status(HttpStatus.OK).body(politicians);
    }

    @GetMapping("/politician/{id}")
    public ResponseEntity<Optional<Politician>> findPoliticianById(@PathVariable Long id) {
        Optional<Politician> politician = politicianRep.findById(id);
        System.out.println(politician.get().getParty().getPoliticians());
        return ResponseEntity.status(HttpStatus.OK).body(politician);
    }

    @GetMapping("/politician-party/{id}")
    public ResponseEntity<List<Politician>> findPoliticiansByPartyId(@PathVariable Long id) {
        List<Politician> politiciansByPartyId = new ArrayList<>();
        List<Politician> politicians = new ArrayList<>();
        politicianRep.findAll().forEach(politicians::add);

        for (int i = 0; i < politicians.size(); i++) {
            if (id == politicians.get(i).getParty().getId()) {
                politiciansByPartyId.add(politicians.get(i));
            }
        }


        return ResponseEntity.status(HttpStatus.OK).body(politiciansByPartyId);
    }


    @PostMapping(value = "/new-politician", consumes = "application/json")
    public ResponseEntity<Politician> savePolitician(@RequestBody Politician politician) {

        return ResponseEntity.ok(politicianRep.save(politician));
    }

    @PutMapping("/politician/{id}")
    public ResponseEntity<Politician> updatePolitician(@PathVariable Long id, @RequestBody Politician politician) {

        Optional<Politician> optionalPolitician = politicianRep.findById(id);

        return ResponseEntity.ok(politicianRep.save(politician));
        /*
        if (optionalPolitician.isPresent()) {
            if (id.equals(politician.getId())) {
                politicianRep.save(politician);
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    */}

    //Works with name
    @DeleteMapping("/politician/{id}")
    public ResponseEntity<String> deletePolitician(@PathVariable Long id) {
        Optional<Politician> politicianToDelete = politicianRep.findById(id);
        politicianRep.deleteById(id);

        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
