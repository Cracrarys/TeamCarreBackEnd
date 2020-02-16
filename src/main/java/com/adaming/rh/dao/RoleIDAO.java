package com.adaming.rh.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adaming.rh.entities.Role;

@Repository
public interface RoleIDAO extends JpaRepository<Role, Long> {

}