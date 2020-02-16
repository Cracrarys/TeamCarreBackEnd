package com.adaming.rh.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adaming.rh.entities.Fourniture;

@Repository
public interface FournitureIDAO extends JpaRepository<Fourniture, Long> {

}
