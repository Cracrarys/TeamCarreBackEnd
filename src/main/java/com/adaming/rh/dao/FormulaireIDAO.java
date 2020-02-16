package com.adaming.rh.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.adaming.rh.entities.FormulaireEmprunt;

@Repository
@CrossOrigin(origins = "http://localhost:4200")
public interface FormulaireIDAO extends JpaRepository<FormulaireEmprunt, Long> {
}
