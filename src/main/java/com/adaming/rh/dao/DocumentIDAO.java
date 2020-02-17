package com.adaming.rh.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.adaming.rh.entities.DocumentRH;

@Repository
public interface DocumentIDAO extends JpaRepository<DocumentRH, Long> {
}
