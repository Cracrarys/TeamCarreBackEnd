package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Role;


@Repository
public interface RoleIDAO extends JpaRepository<Role, Long> {

}
