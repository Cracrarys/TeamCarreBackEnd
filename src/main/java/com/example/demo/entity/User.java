package com.example.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "users")
public class User {

	@Id
	private long iduser;
	@Column
	private String username;
	@Column
	private String password;
	@Column
	private boolean activated;
	@OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
	@JsonIgnore
	private List<Role> roles;

	public long getIduser() {
		return iduser;
	}

	public void setIduser(long iduser) {
		this.iduser = iduser;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public User(long iduser, String username, String password, boolean activated) {
		super();
		this.iduser = iduser;
		this.username = username;
		this.password = password;
		this.activated = activated;
	}

	public User() {
		super();
	}

	@Override
	public String toString() {
		return "User [iduser=" + iduser + ", username=" + username + "]";
	}

}
