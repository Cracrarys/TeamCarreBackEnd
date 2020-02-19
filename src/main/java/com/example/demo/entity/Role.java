package com.example.demo.entity;

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
	private long idrole;
	@Column(name = "rolename")
	private String rolename;
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "iduser")

	private User user;

	public long getIdrole() {
		return idrole;
	}

	public void setIdrole(long idrole) {
		this.idrole = idrole;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Role(long idrole, String rolename, User user) {
		super();
		this.idrole = idrole;
		this.rolename = rolename;
		this.user = user;
	}

	public Role() {
		super();
	}

	@Override
	public String toString() {
		return "Role [idrole=" + idrole + ", rolename=" + rolename + ", user=" + user + "]";
	}

}
