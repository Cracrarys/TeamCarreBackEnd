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

import com.example.demo.entity.DocumentRH;
import com.example.demo.entity.Employe;
import com.example.demo.entity.FormulaireEmprunt;
import com.example.demo.entity.Fourniture;
import com.example.demo.service.DocumentService;
import com.example.demo.service.EmployeService;
import com.example.demo.service.FormulaireService;
import com.example.demo.service.FournitureService;

@Controller
@RequestMapping(value = "/Employe")
public class EmployeController {
	@Autowired
	private EmployeService empServ;

	@Autowired
	private DocumentService docServ;

	@Autowired
	private FormulaireService forServ;

	@Autowired
	private FournitureService fourServ;

	public DocumentService getDocServ() {
		return docServ;
	}

	public void setDocServ(DocumentService docServ) {
		this.docServ = docServ;
	}

	public FormulaireService getForServ() {
		return forServ;
	}

	public void setForServ(FormulaireService forServ) {
		this.forServ = forServ;
	}

	public FournitureService getFourServ() {
		return fourServ;
	}

	public void setFourServ(FournitureService fourServ) {
		this.fourServ = fourServ;
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

		return "employe";
	}

	@RequestMapping(value = "/Ajout", method = RequestMethod.POST)
	public String AjoutEmploye(@ModelAttribute("employe") Employe employe) {
		empServ.AjoutEmployeService(employe);
		return direction;

	}

	@RequestMapping(value = "/Update", method = RequestMethod.POST)
	public ModelAndView UpdateEmploye(@ModelAttribute("employe") Employe employe) {

		empServ.UpdateEmployeService(employe);
		return new ModelAndView(direction);

	}

	@RequestMapping(value = "/Supprimer", method = RequestMethod.POST)
	public String SuppEmploye(@RequestParam("empID") String empID) {

		List<Employe> lstEmp = empServ.GetAllEmploye();
		List<DocumentRH> lstDoc = docServ.GetAllDocument();
		List<FormulaireEmprunt> lstForm = forServ.GetAllFormulaire();
		List<Fourniture> lstFour = fourServ.GetAllFourniture();

		Employe emp = empServ.GetByIdEmploye(Long.parseLong(empID));
		lstEmp.remove(emp);
		empServ.SupprimerEmployeService(emp);

		for (Employe empl : lstEmp) {
			empServ.AjoutEmployeService(empl);
		}

		for (DocumentRH doc : lstDoc) {
			Employe empl = doc.getEmploye();
			if (empl.getIdEmploye() == emp.getIdEmploye()) {
				doc.setEmploye(null);
			}
			docServ.AjoutDocumentService(doc);
		}

		for (FormulaireEmprunt form : lstForm) {
			Employe empl = form.getEmploye();
			if (empl.getIdEmploye() == emp.getIdEmploye()) {
				form.setEmploye(null);
			}
			forServ.AjoutFormulaireService(form);
		}

		for (Fourniture four : lstFour) {
			List<Employe> lstEmploye = four.getEmploye();
			lstEmploye.remove(emp);
			four.setEmploye(lstEmploye);
			fourServ.AjoutFournitureService(four);
		}
		return direction;

	}

	@RequestMapping(value = "/All", method = RequestMethod.GET)
	public String getAllEmploye(@ModelAttribute("employe") Employe employe, ModelMap model) {
		model.addAttribute("listeEmploye", empServ.GetAllEmploye());
		return "employeall";

	}

	@RequestMapping(value = "/Chercher", method = RequestMethod.GET)
	public String getByIdEmploye(@ModelAttribute("employe") Employe employe, ModelMap model) {
		model.addAttribute("leEmploye", empServ.GetByIdEmploye(employe.getIdEmploye()));
		return "leemploye";

	}
}
