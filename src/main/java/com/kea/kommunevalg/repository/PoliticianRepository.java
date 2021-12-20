package com.kea.kommunevalg.repository;

import com.kea.kommunevalg.model.Politician;
import org.springframework.data.repository.CrudRepository;

public interface PoliticianRepository extends CrudRepository<Politician, String> {
}
