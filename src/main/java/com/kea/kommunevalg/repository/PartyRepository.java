package com.kea.kommunevalg.repository;

import com.kea.kommunevalg.model.Party;
import org.springframework.data.repository.CrudRepository;

public interface PartyRepository extends CrudRepository<Party, Long> {
}
