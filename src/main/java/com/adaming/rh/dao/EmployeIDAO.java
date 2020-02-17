package com.adaming.rh.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.adaming.rh.entities.Employe;

@Repository
public interface EmployeIDAO extends JpaRepository<Employe, Long> {
}
