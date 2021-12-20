package com.kea.kommunevalg.repository;

import com.kea.kommunevalg.model.Politician;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PoliticianRepository extends CrudRepository<Politician, String> {

}
