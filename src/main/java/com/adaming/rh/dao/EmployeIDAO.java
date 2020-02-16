package com.adaming.rh.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.adaming.rh.entities.Employe;

@Repository
@CrossOrigin(origins = "http://localhost:4200")
public interface EmployeIDAO extends JpaRepository<Employe, Long> {
}
