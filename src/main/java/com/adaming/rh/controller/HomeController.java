package com.adaming.rh.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller()

public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	@RequestMapping(value = "/initEmploye", method = RequestMethod.GET)
	public String initEmploye() {

		return "redirect:/Employe/All";
	}

	@RequestMapping(value = "/initDocument", method = RequestMethod.GET)
	public String initDocument() {

		return "redirect:/Document/All";
	}

	@RequestMapping(value = "/initFourniture", method = RequestMethod.GET)
	public String initFourniture() {

		return "redirect:/Fourniture/All";
	}

	@RequestMapping(value = "/initFormulaire", method = RequestMethod.GET)
	public String initFormulaire() {

		return "redirect:/Formulaire/All";
	}

	@RequestMapping(value = "/initRole", method = RequestMethod.GET)
	public String initRole() {

		return "redirect:/Role/All";
	}

	@RequestMapping(value = "/initUser", method = RequestMethod.GET)
	public String initUser() {

		return "redirect:/User/All";
	}

}
