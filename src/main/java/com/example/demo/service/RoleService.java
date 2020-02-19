package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.RoleIDAO;
import com.example.demo.entity.Role;


@Service
public class RoleService {
	@Autowired
	private RoleIDAO roledao;

	public RoleIDAO getRoledao() {
		return roledao;
	}

	public void setRoledao(RoleIDAO roledao) {
		this.roledao = roledao;
	}

	public void ajoutRoleService(Role role) {
		roledao.save(role);
	}

	public void supprimerRoleService(Role role) {
		roledao.delete(role);
	}

	public Role getByIdRole(Long idClient) {
		return roledao.getOne(idClient);
	}

	public List<Role> getAllRole() {
		return roledao.findAll();
	}

	public void updateRoleService(Role role) {
		roledao.saveAndFlush(role);
	}

}
