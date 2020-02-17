package com.adaming.rh.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adaming.rh.dao.UserIDAO;
import com.adaming.rh.entities.User;

@Service
public class UserService {
	@Autowired
	private UserIDAO userdao;

	public UserIDAO getUserdao() {
		return userdao;
	}

	public void setUserdao(UserIDAO userdao) {
		this.userdao = userdao;
	}

	public void AjoutUserService(User user) {
		userdao.save(user);
	}

	public void SupprimerUserService(User user) {
		userdao.delete(user);
	}

	public User GetByIdUser(Long idClient) {
		return userdao.getOne(idClient);
	}

	public List<User> GetAllUser() {
		return userdao.findAll();
	}

	public void UpdateUserService(User user) {
		userdao.saveAndFlush(user);
	}

}
