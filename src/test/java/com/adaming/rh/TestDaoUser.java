package com.adaming.rh;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.adaming.rh.entities.User;
import com.adaming.rh.services.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src//test//resources//root-context.xml")
public class TestDaoUser {
	@Autowired
	private UserService userdao;

	User user = new User();

	public UserService getUserdao() {
		return userdao;
	}

	public void setUserdao(UserService userdao) {
		this.userdao = userdao;
	}

	@Before
	public void setUp() {
		user.setIdUser(11L);
		user.setPassword("123456");
		user.setActivated(true);
		user.setLogin("AZERTY");
	}

	@Test
	public void AjoutUser() {
		userdao.AjoutUserService(this.user);
		User userfound = userdao.GetByIdUser(11L);
		assertEquals(userfound.toString(), user.toString());
	}
}
