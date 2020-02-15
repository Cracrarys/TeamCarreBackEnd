package com.adaming.rh.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role {

	@Id
	private long idRole;
	@Column(name = "rolename")
	private String titreRole;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idUser")
	private User user;

	public long getIdRole() {
		return idRole;
	}

	public void setIdRole(long idRole) {
		this.idRole = idRole;
	}

	public String getTitreRole() {
		return titreRole;
	}

	public void setTitreRole(String titreRole) {
		this.titreRole = titreRole;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Role [idRole=" + idRole + ", titreRole=" + titreRole + ", user=" + user + "]";
	}

	public Role(long idRole, String titreRole, User user) {
		super();
		this.idRole = idRole;
		this.titreRole = titreRole;
		this.user = user;
	}

	public Role() {
		super();
	}

}