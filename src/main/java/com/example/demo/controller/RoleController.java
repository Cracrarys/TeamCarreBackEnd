package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.service.RoleService;
import com.example.demo.service.UserService;

@Controller
@RequestMapping(value = "/Role")
public class RoleController {
	@Autowired
	private RoleService rolServ;
	@Autowired
	private UserService userServ;

	public RoleService getRolServ() {
		return rolServ;
	}

	public void setRolServ(RoleService rolServ) {
		this.rolServ = rolServ;
	}

	public UserService getUserServ() {
		return userServ;
	}

	public void setUserServ(UserService userServ) {
		this.userServ = userServ;
	}

	String direction = "redirect:All";
	
	@RequestMapping(value = "/init", method =RequestMethod.GET)
	public String init(ModelMap model) {
		model.addAttribute("listeDesUsers2", userServ.getAllUser());
		model.addAttribute("listeDesRoles2", rolServ.getAllRole());
		return "role";
	}

	@RequestMapping(value = "/Ajout", method = RequestMethod.POST)
	public String ajoutTache(@ModelAttribute("role") Role role, ServletRequest req) {
		List<String> liststr = Arrays.asList(req.getParameterValues("useID"));
		for (String setri : liststr)
			role.setUser(userServ.getByIdUser(Long.parseLong(setri)));
		rolServ.ajoutRoleService(role);
		return direction;

	}

	@RequestMapping(value = "/Supprimer", method = RequestMethod.POST)
	public String suppRole(@RequestParam("roleID") String roleID) {
		List<User> lstUser = userServ.getAllUser();
		List<Role> lstRole = rolServ.getAllRole();

		Role role = rolServ.getByIdRole(Long.parseLong(roleID));
		lstRole.remove(role);
		rolServ.supprimerRoleService(role);

		for (Role rol : lstRole) {
			rolServ.ajoutRoleService(rol);
		}

		for (User use : lstUser) {
			List<Role> lstRole2 = use.getRoles();
			lstRole2.remove(role);
			use.setRoles(lstRole2);
			userServ.ajoutUserService(use);
		}
		return direction;

	}

	@RequestMapping(value = "/All", method = RequestMethod.GET)
	public String getAllTache(@ModelAttribute("role") Role role, ModelMap model) {
		model.addAttribute("listeDesRoles", rolServ.getAllRole());
		model.addAttribute("listeDesUsers", userServ.getAllUser());
		return "roleall";

	}

	@RequestMapping(value = "/Chercher", method = RequestMethod.GET)
	public String getByIdRole(@ModelAttribute("role") Role role, ModelMap model) {
		model.addAttribute("leRole", rolServ.getByIdRole(role.getIdrole()));
		return "lerole";

	}
}
