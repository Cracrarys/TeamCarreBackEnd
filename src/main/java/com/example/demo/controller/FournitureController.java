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
	private FournitureService fouServ;

	@Autowired
	private FormulaireService forServ;

	@Autowired
	private EmployeService empServ;

	public FournitureService getFouServ() {
		return fouServ;
	}

	public void setFouServ(FournitureService fouServ) {
		this.fouServ = fouServ;
	}

	public EmployeService getEmpServ() {
		return empServ;
	}

	public void setEmpServ(EmployeService empServ) {
		this.empServ = empServ;
	}

	public void setForServ(FormulaireService forServ) {
		this.forServ = forServ;
	}

	public FournitureService getForServ() {
		return fouServ;
	}

	public void setForServ(FournitureService fouServ) {
		this.fouServ = fouServ;
	}

	String direction = "redirect:All";

	@RequestMapping(value = "/init")
	public String init() {

		return "fourniture";
	}

	@RequestMapping(value = "/Ajout", method = RequestMethod.POST)
	public String AjoutFourniture(@ModelAttribute("fourniture") Fourniture fourniture, ServletRequest req) {
		fouServ.AjoutFournitureService(fourniture);
		return direction;

	}

	@RequestMapping(value = "/Update", method = RequestMethod.POST)
	public ModelAndView UpdateFourniture(@ModelAttribute("fourniture") Fourniture fourniture) {
		fouServ.UpdateFournitureService(fourniture);
		return new ModelAndView(direction);
	}

	@RequestMapping(value = "/Supprimer", method = RequestMethod.POST)
	public String SuppFourniture(@RequestParam("fourID") String fourID) {
		List<Employe> lstEmp = empServ.GetAllEmploye();
		List<FormulaireEmprunt> lstForm = forServ.GetAllFormulaire();
		List<Fourniture> lstFour = fouServ.GetAllFourniture();

		Fourniture four = fouServ.GetByIdFourniture(Long.parseLong(fourID));
		lstFour.remove(four);
		fouServ.SupprimerFournitureService(four);

		for (Fourniture fourn : lstFour) {
			fouServ.AjoutFournitureService(fourn);
		}
		for (Employe emp : lstEmp) {
			List<Fourniture> lstFourni = emp.getFourniture();
			lstFourni.remove(four);
			emp.setFourniture(lstFourni);
			empServ.AjoutEmployeService(emp);
		}
		for (FormulaireEmprunt form : lstForm) {
			Fourniture fourn = form.getFourniture();
			if (fourn.getIdFourniture() == four.getIdFourniture()) {
				form.setFourniture(null);
			}
			forServ.AjoutFormulaireService(form);
		}
		return direction;

	}

	@RequestMapping(value = "/All", method = RequestMethod.GET)
	public String getAllFourniture(@ModelAttribute("fourniture") Fourniture fourniture, ModelMap model) {
		model.addAttribute("listeFourniture", fouServ.GetAllFourniture());
		return "fourniture";

	}

	@RequestMapping(value = "/Chercher", method = RequestMethod.GET)
	public String getByIdFourniture(@ModelAttribute("fourniture") Fourniture fourniture, ModelMap model) {
		model.addAttribute("leFourniture", fouServ.GetByIdFourniture(fourniture.getIdFourniture()));
		return "lefourniture";

	}
}
