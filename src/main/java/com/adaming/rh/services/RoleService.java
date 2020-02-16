package com.adaming.rh.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adaming.rh.dao.RoleIDAO;
import com.adaming.rh.entities.Role;

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

	public void AjoutRoleService(Role role) {
		roledao.save(role);
	}

	public void SupprimerRoleService(Role role) {
		roledao.delete(role);
	}

	public Role GetByIdRole(Long idClient) {
		return roledao.getOne(idClient);
	}

	public List<Role> GetAllRole() {
		return roledao.findAll();
	}

	public void UpdateRoleService(Role role) {
		roledao.saveAndFlush(role);
	}

}
