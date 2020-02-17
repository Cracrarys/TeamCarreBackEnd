package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@Controller
@RequestMapping(value = "/User")
public class UserController {
	@Autowired
	private UserService userServ;

	public UserService getUserServ() {
		return userServ;
	}

	public void setUserServ(UserService userServ) {
		this.userServ = userServ;
	}

	String direction = "redirect:All";

	@RequestMapping(value = "/Ajout", method = RequestMethod.POST)
	public ModelAndView AjoutUtilisateur(@ModelAttribute("user") User user) {
		userServ.AjoutUserService(user);
		return new ModelAndView(direction);

	}

	@RequestMapping(value = "/Update", method = RequestMethod.POST)
	public ModelAndView UpdateUtilisateur(@ModelAttribute("user") User user) {
		userServ.UpdateUserService(user);
		return new ModelAndView(direction);

	}

	@RequestMapping(value = "/Supprimer", method = RequestMethod.POST)
	public String SuppUtilisateur(@ModelAttribute("user") User user) {
		userServ.SupprimerUserService(user);
		return direction;

	}

	@RequestMapping(value = "/All", method = RequestMethod.GET)
	public String getAllUtilisateur(@ModelAttribute("user") User user, ModelMap model) {
		model.addAttribute("listeDesUsers", userServ.GetAllUser());
		return "user";

	}

	@RequestMapping(value = "/Chercher", method = RequestMethod.GET)
	public String getByIdUser(@ModelAttribute("user") User user, ModelMap model) {
		model.addAttribute("leUser", userServ.GetByIdUser(user.getIdUser()));
		return "leuser";

	}
}
