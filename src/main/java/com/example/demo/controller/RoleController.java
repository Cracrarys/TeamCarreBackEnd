package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entity.Role;
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

	@RequestMapping(value = "/Ajout", method = RequestMethod.POST)
	public String AjoutTache(@ModelAttribute("role") Role role, ServletRequest req) {
		List<String> liststr = new ArrayList<String>();
		liststr = Arrays.asList(req.getParameterValues("useID"));

		for (String setri : liststr)
			role.setUser(userServ.GetByIdUser(Long.parseLong(setri)));

		rolServ.AjoutRoleService(role);
		return direction;

	}

	@RequestMapping(value = "/Supprimer", method = RequestMethod.POST)
	public String SuppTache(@ModelAttribute("role") Role role) {
		rolServ.SupprimerRoleService(role);
		return direction;

	}

	@RequestMapping(value = "/All", method = RequestMethod.GET)
	public String getAllTache(@ModelAttribute("role") Role role, ModelMap model) {
		model.addAttribute("listeDesRoles", rolServ.GetAllRole());
		model.addAttribute("listeDesUsers", userServ.GetAllUser());
		return "role";

	}

	@RequestMapping(value = "/Chercher", method = RequestMethod.GET)
	public String getByIdRole(@ModelAttribute("role") Role role, ModelMap model) {
		model.addAttribute("leRole", rolServ.GetByIdRole(role.getIdrole()));
		return "lerole";

	}
}
