package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserIDAO;
import com.example.demo.entity.User;


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

	public void ajoutUserService(User user) {
		userdao.save(user);
	}

	public void supprimerUserService(User user) {
		userdao.delete(user);
	}

	public User getByIdUser(Long idClient) {
		return userdao.getOne(idClient);
	}

	public List<User> getAllUser() {
		return userdao.findAll();
	}

	public void updateUserService(User user) {
		userdao.saveAndFlush(user);
	}

}
