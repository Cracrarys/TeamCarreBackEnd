package com.example.demo.controller;

import java.util.List;

import javax.servlet.ServletRequest;

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
@RequestMapping(value = "/Fourniture")
public class FournitureController {
	@Autowired
	private FournitureService fourServ;

	@Autowired
	private FormulaireService formuServ;

	@Autowired
	private EmployeService empServ;

	public FournitureService getFourServ() {
		return fourServ;
	}

	public void setFourServ(FournitureService fourServ) {
		this.fourServ = fourServ;
	}

	public FormulaireService getFormuServ() {
		return formuServ;
	}

	public void setFormuServ(FormulaireService formuServ) {
		this.formuServ = formuServ;
	}

	public EmployeService getEmpServ() {
		return empServ;
	}

	public void setEmpServ(EmployeService empServ) {
		this.empServ = empServ;
	}

	String direction = "redirect:All";

	@RequestMapping(value = "/init")
	public String init() {

		return "fourniture";
	}

	@RequestMapping(value = "/find")
	public String find() {

		return "fourniturefind";
	}

	@RequestMapping(value = "/Ajout", method = RequestMethod.POST)
	public String ajoutFourniture(@ModelAttribute("fourniture") Fourniture fourniture, ServletRequest req) {
		fourServ.ajoutFournitureService(fourniture);
		return direction;

	}

	@RequestMapping(value = "/Update", method = RequestMethod.POST)
	public ModelAndView updateFourniture(@ModelAttribute("fourniture") Fourniture fourniture) {
		fourServ.updateFournitureService(fourniture);
		return new ModelAndView(direction);
	}

	@RequestMapping(value = "/Supprimer", method = RequestMethod.POST)
	public String suppFourniture(@RequestParam("fourID") String fourID) {
		List<Employe> lstEmp = empServ.getAllEmploye();
		List<FormulaireEmprunt> lstForm = formuServ.getAllFormulaire();
		List<Fourniture> lstFour = fourServ.getAllFourniture();

		Fourniture four = fourServ.getByIdFourniture(Long.parseLong(fourID));
		lstFour.remove(four);
		fourServ.supprimerFournitureService(four);

		for (Fourniture fourn : lstFour) {
			fourServ.ajoutFournitureService(fourn);
		}
		for (Employe emp : lstEmp) {
			List<Fourniture> lstFourni = emp.getFourniture();
			lstFourni.remove(four);
			emp.setFourniture(lstFourni);
			empServ.ajoutEmployeService(emp);
		}
		for (FormulaireEmprunt form : lstForm) {
			Fourniture fourn = form.getFourniture();
			if (fourn.getIdFourniture() == four.getIdFourniture()) {
				form.setFourniture(null);
			}
			formuServ.ajoutFormulaireService(form);
		}
		return direction;

	}

	@RequestMapping(value = "/All", method = RequestMethod.GET)
	public String getAllFourniture(@ModelAttribute("fourniture") Fourniture fourniture, ModelMap model) {
		model.addAttribute("listeFourniture", fourServ.getAllFourniture());
		return "fourniture";

	}

	@RequestMapping(value = "/ChercherByID", method = RequestMethod.GET)
	public String getByIdFourniture(@RequestParam("fourID") String fourID, ModelMap model) {
		Fourniture four = fourServ.getByIdFourniture(Long.parseLong(fourID));
		model.addAttribute("leFourniture", four);
		return "leformulaire";

	}

	@RequestMapping(value = "/ChercherByName", method = RequestMethod.GET)
	public String getByNameFourniture(@RequestParam("fourNAME") String fourNAME, ModelMap model) {
		List<Fourniture> listeFour = fourServ.getFournitureByName(fourNAME);
		model.addAttribute("lesFournitureNom", listeFour);
		return "lesfournituresNom";

	}
}
