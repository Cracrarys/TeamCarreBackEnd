package com.adaming.rh.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adaming.rh.entities.User;

@Repository
public interface UserIDAO extends JpaRepository<User, Long> {

}
