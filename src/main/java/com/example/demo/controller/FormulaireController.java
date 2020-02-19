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

	@RequestMapping(value = "/init", method = RequestMethod.GET )
	public String init(ModelMap model) {
		model.addAttribute("listeEmployebis", empServ.GetAllEmploye());
		model.addAttribute("ListeFourniturebis", fourServ.GetAllFourniture());
		return "formulaire";
	}

	@RequestMapping(value = "/Ajout", method = RequestMethod.POST)
	public String AjoutFormulaire(@ModelAttribute("formulaire") FormulaireEmprunt form,
			@RequestParam("empID") String empID, @RequestParam("fourID") String fourID) {
		Employe emp = empServ.GetByIdEmploye(Long.parseLong(empID));
		Fourniture four = fourServ.GetByIdFourniture(Long.parseLong(fourID));
		int quantite = form.getQuantite();
		if (four.getQuantiteDisponible() >= quantite) {
			if (four.isConsommable()) {
				four.setQuantiteTotale(four.getQuantiteTotale() - quantite);
			}
			four.setQuantiteDisponible(four.getQuantiteDisponible() - quantite);
			form.setEmploye(emp);
			form.setFourniture(four);
			forServ.AjoutFormulaireService(form);
		}
		return direction;

	}

	@RequestMapping(value = "/Update", method = RequestMethod.POST)
	public ModelAndView UpdateFormulaire(@ModelAttribute("formulaire") FormulaireEmprunt formulaire) {
		forServ.UpdateFormulaireService(formulaire);
		return new ModelAndView(direction);
	}

	@RequestMapping(value = "/Supprimer", method = RequestMethod.POST)
	public String SuppFormulaire(@RequestParam("fourID") String fourID) {
		List<FormulaireEmprunt> lstForm = forServ.GetAllFormulaire();
		List<Employe> lstEmp = empServ.GetAllEmploye();
		List<Fourniture> lstFour = fourServ.GetAllFourniture();

		FormulaireEmprunt formu = forServ.GetByIdFormulaire(Long.parseLong(fourID));
		lstForm.remove(formu);
		forServ.SupprimerFormulaireService(formu);

		for (FormulaireEmprunt form : lstForm) {
			forServ.AjoutFormulaireService(form);
		}

		for (Employe emp : lstEmp) {
			List<FormulaireEmprunt> lstFormulaire = emp.getFormulaire();
			lstFormulaire.remove(formu);
			emp.setFormulaire(lstFormulaire);
			empServ.AjoutEmployeService(emp);
		}

		for (Fourniture four : lstFour) {
			List<FormulaireEmprunt> lstFormulaire = four.getFormulaire();
			lstFormulaire.remove(formu);
			four.setFormulaire(lstFormulaire);
			fourServ.AjoutFournitureService(four);
		}
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
