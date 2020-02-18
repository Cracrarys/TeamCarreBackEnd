package com.example.demo.controller;

import javax.servlet.ServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.FormulaireEmprunt;
import com.example.demo.service.FormulaireService;

@Controller
@RequestMapping(value = "/Formulaire")
public class FormulaireController {
	@Autowired
	private FormulaireService forServ;

	public FormulaireService getForServ() {
		return forServ;
	}

	public void setForServ(FormulaireService forServ) {
		this.forServ = forServ;
	}

	String direction = "redirect:All";

	@RequestMapping(value = "/init")
	public String init() {
		
		return "formulaire";
	}
	
	@RequestMapping(value = "/Ajout", method = RequestMethod.POST)
	public String AjoutFormulaire(@ModelAttribute("formulaire") FormulaireEmprunt formulaire, ServletRequest req) {
		forServ.AjoutFormulaireService(formulaire);
		return direction;

	}

	@RequestMapping(value = "/Update", method = RequestMethod.POST)
	public ModelAndView UpdateFormulaire(@ModelAttribute("formulaire") FormulaireEmprunt formulaire) {
		forServ.UpdateFormulaireService(formulaire);
		return new ModelAndView(direction);
	}

	@RequestMapping(value = "/Supprimer", method = RequestMethod.POST)
	public String SuppFormulaire(@ModelAttribute("formulaire") FormulaireEmprunt formulaire) {
		forServ.SupprimerFormulaireService(formulaire);
		return direction;

	}

	@RequestMapping(value = "/All", method = RequestMethod.GET)
	public String getAllFormulaire(@ModelAttribute("formulaire") FormulaireEmprunt formulaire, ModelMap model) {
		model.addAttribute("listeFormulaire", forServ.GetAllFormulaire());
		return "formulaire";

	}

	@RequestMapping(value = "/Chercher", method = RequestMethod.GET)
	public String getByIdFormulaire(@ModelAttribute("formulaire") FormulaireEmprunt formulaire, ModelMap model) {
		model.addAttribute("leFormulaire", forServ.GetByIdFormulaire(formulaire.getIdFormulaire()));
		return "leformulaire";

	}
}
