package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Employe;
import com.example.demo.entity.FormulaireEmprunt;
import com.example.demo.entity.Fourniture;
import com.example.demo.service.EmployeService;
import com.example.demo.service.FormulaireService;
import com.example.demo.service.FournitureService;

@Controller
@RequestMapping(value = "/Formulaire")
public class FormulaireController {
	@Autowired
	private FormulaireService forServ;

	@Autowired
	private EmployeService empServ;

	@Autowired
	private FournitureService fourServ;

	public EmployeService getEmpServ() {
		return empServ;
	}

	public void setEmpServ(EmployeService empServ) {
		this.empServ = empServ;
	}

	public FournitureService getFourServ() {
		return fourServ;
	}

	public void setFourServ(FournitureService fourServ) {
		this.fourServ = fourServ;
	}

	public FormulaireService getForServ() {
		return forServ;
	}

	public void setForServ(FormulaireService forServ) {
		this.forServ = forServ;
	}

	String direction = "redirect:All";

	@RequestMapping(value = "/init", method = RequestMethod.GET)
	public String init(ModelMap model) {
		model.addAttribute("listeEmployebis", empServ.getAllEmploye());
		model.addAttribute("ListeFourniturebis", fourServ.getAllFourniture());
		return "formulaire";

	}

	@RequestMapping(value = "/find")
	public String find() {

		return "formulairefind";
	}

	@RequestMapping(value = "/Ajout", method = RequestMethod.POST)
	public String ajoutFormulaire(@ModelAttribute("formulaire") FormulaireEmprunt form,
			@RequestParam("empID") String empID, @RequestParam("fourID") String fourID) {
		Employe emp = empServ.getByIdEmploye(Long.parseLong(empID));
		Fourniture four = fourServ.getByIdFourniture(Long.parseLong(fourID));
		int quantite = form.getQuantite();
		if (four.getQuantiteDisponible() >= quantite) {
			if (four.isConsommable()) {
				four.setQuantiteTotale(four.getQuantiteTotale() - quantite);
			}
			four.setQuantiteDisponible(four.getQuantiteDisponible() - quantite);
			form.setEmploye(emp);
			form.setFourniture(four);
			forServ.ajoutFormulaireService(form);
		}
		return "redirect:All2";
	}

	@RequestMapping(value = "/Update", method = RequestMethod.POST)
	public ModelAndView updateFormulaire(@ModelAttribute("formulaire") FormulaireEmprunt form,
			@RequestParam("empID") String empID, @RequestParam("fourID") String fourID) {
		Employe emp = empServ.getByIdEmploye(Long.parseLong(empID));
		Fourniture four = fourServ.getByIdFourniture(Long.parseLong(fourID));
		int quantite = form.getQuantite();
		if (four.getQuantiteDisponible() >= quantite) {
			if (four.isConsommable()) {
				four.setQuantiteTotale(four.getQuantiteTotale() - quantite);
			}
			four.setQuantiteDisponible(four.getQuantiteDisponible() - quantite);
			form.setEmploye(emp);
			form.setFourniture(four);
			forServ.updateFormulaireService(form);
		}
		return new ModelAndView("redirect:All2");
	}

	@RequestMapping(value = "/Supprimer", method = RequestMethod.POST)
	public String suppFormulaire(@RequestParam("fourID") String fourID) {
		List<FormulaireEmprunt> lstForm = forServ.getAllFormulaire();
		List<Employe> lstEmp = empServ.getAllEmploye();
		List<Fourniture> lstFour = fourServ.getAllFourniture();

		FormulaireEmprunt formu = forServ.getByIdFormulaire(Long.parseLong(fourID));
		lstForm.remove(formu);
		forServ.supprimerFormulaireService(formu);

		for (FormulaireEmprunt form : lstForm) {
			forServ.ajoutFormulaireService(form);
		}

		for (Employe emp : lstEmp) {
			List<FormulaireEmprunt> lstFormulaire = emp.getFormulaire();
			lstFormulaire.remove(formu);
			emp.setFormulaire(lstFormulaire);
			empServ.ajoutEmployeService(emp);
		}

		for (Fourniture four : lstFour) {
			List<FormulaireEmprunt> lstFormulaire = four.getFormulaire();
			lstFormulaire.remove(formu);
			four.setFormulaire(lstFormulaire);
			fourServ.ajoutFournitureService(four);
		}
		return direction;

	}

	@RequestMapping(value = "/All", method = RequestMethod.GET)
	public String getAllFormulaireTrue(@ModelAttribute("formulaire") FormulaireEmprunt formulaire, ModelMap model) {
		model.addAttribute("listeFormulaire", forServ.getAllFormulaireTrue(true));
		return "formulaireall";

	}

	@RequestMapping(value = "/All2", method = RequestMethod.GET)
	public String getAllFormulaireFalse(@ModelAttribute("formulaire") FormulaireEmprunt formulaire, ModelMap model) {
		model.addAttribute("listeFormulaire2", forServ.getAllFormulaireFalse(false));
		model.addAttribute("listeEmployebis", empServ.getAllEmploye());
		model.addAttribute("ListeFourniturebis", fourServ.getAllFourniture());
		return "formulairevalid";

	}

	@RequestMapping(value = "/ChercherById", method = RequestMethod.GET)
	public String getByIdFormulaire(@RequestParam("forID") String forID, ModelMap model,
			@ModelAttribute("formulaire") FormulaireEmprunt formulaire) {
		model.addAttribute("leFormulaire", forServ.getByIdFormulaire(formulaire.getIdFormulaire()));
		return "leformulaire";

	}

	@RequestMapping(value = "/ChercherByName", method = RequestMethod.GET)
	public String getByNameDocument(@RequestParam("forNAME") String forNAME, ModelMap model) {
		List<FormulaireEmprunt> listeFor = forServ.getForByName(forNAME);
		model.addAttribute("listFormulaire", listeFor);
		return "leformulaire2";

	}
}
