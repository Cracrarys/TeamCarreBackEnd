package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "users")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class User {

	@Id
	private long idUser;
	@Column
	private String login;
	@Column
	private String password;
	@Column
	private boolean activated;
	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private List<Role> roles = new ArrayList<>();

	public long getIdUser() {
		return idUser;
	}

	public void setIdUser(long idUser) {
		this.idUser = idUser;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActivated() {
		return activated;
	}

	public void setActivated(boolean activated) {
		this.activated = activated;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public User(long idUser, String login, String password, boolean activated) {
		super();
		this.idUser = idUser;
		this.login = login;
		this.password = password;
		this.activated = activated;
	}

	public User() {
		super();
	}

	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", login=" + login + ", password=" + password + ", activated=" + activated
				+ ", roles=" + roles + "]";
	}

}
