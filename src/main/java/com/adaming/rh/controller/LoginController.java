package com.adaming.rh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	@RequestMapping(value="/login")	
	public String getLogin() {
		return "login";
	}
	@RequestMapping(value="/erreur")	
	public String getErreur() {
		return "erreur";
	}
}
