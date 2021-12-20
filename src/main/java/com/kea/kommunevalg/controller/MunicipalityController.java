package com.kea.kommunevalg.controller;

import com.kea.kommunevalg.model.Party;
import com.kea.kommunevalg.model.Politician;
import com.kea.kommunevalg.repository.PartyRepository;
import com.kea.kommunevalg.repository.PoliticianRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MunicipalityController {

    PartyRepository partyRep;
    PoliticianRepository politicianRep;

    public MunicipalityController(PartyRepository partyRep, PoliticianRepository politicianRep) {
        this.partyRep = partyRep;
        this.politicianRep = politicianRep;
    }

    @GetMapping("/")
    public List<Party> index () {
        List<Party> parties = new ArrayList<>();
        partyRep.findAll().forEach(parties::add);
        System.out.println(parties.get(1).getPartyName());
     return parties;
    }

    @PostMapping("/save-politician")
    public Politician savePolitician (@RequestBody Politician politician) {
        return politicianRep.save(politician);
    }

    @PutMapping("/update-politician")
    public Politician updatePolitician (@PathVariable String name, @RequestBody Politician politician) {
        if (politicianRep.existsById(name)) {
            return politicianRep.save(politician);
        } else {
            System.out.println("Could not find politician by specified name");
        }
        //TODO Create responseentity
        return politicianRep.save(politician);
    }
}
