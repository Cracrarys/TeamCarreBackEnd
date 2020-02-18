package com.example.demo.controller;

import javax.servlet.ServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Employe;
import com.example.demo.service.EmployeService;

@Controller
@RequestMapping(value = "/Employe")
public class EmployeController {
	@Autowired
	private EmployeService empServ;

	public EmployeService getEmpServ() {
		return empServ;
	}

	public void setEmpServ(EmployeService empServ) {
		this.empServ = empServ;
	}

	String direction = "redirect:All";

	@RequestMapping(value = "/Ajout", method = RequestMethod.POST)
	public String AjoutEmploye(@ModelAttribute("employe") Employe employe, ServletRequest req) {
		empServ.AjoutEmployeService(employe);
		return direction;

	}

	@RequestMapping(value = "/Update", method = RequestMethod.POST)
	public ModelAndView UpdateEmploye(@ModelAttribute("employe") Employe employe) {

		empServ.UpdateEmployeService(employe);
		return new ModelAndView(direction);

	}

	@RequestMapping(value = "/Supprimer", method = RequestMethod.POST)
	public String SuppEmploye(@ModelAttribute("employe") Employe employe) {
		empServ.SupprimerEmployeService(employe);
		return direction;

	}

	@RequestMapping(value = "/All", method = RequestMethod.GET)
	public String getAllEmploye(@ModelAttribute("employe") Employe employe, ModelMap model) {
		model.addAttribute("listeEmploye", empServ.GetAllEmploye());
		return "employe";

	}

	@RequestMapping(value = "/Chercher", method = RequestMethod.GET)
	public String getByIdEmploye(@ModelAttribute("employe") Employe employe, ModelMap model) {
		model.addAttribute("leEmploye", empServ.GetByIdEmploye(employe.getIdEmploye()));
		return "leemploye";

	}
}
