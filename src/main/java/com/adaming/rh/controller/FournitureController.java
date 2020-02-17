package com.adaming.rh.controller;

import javax.servlet.ServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.ModelAndView;

import com.adaming.rh.entities.Fourniture;
import com.adaming.rh.services.FournitureService;

@Controller
@RequestMapping(value = "/Fourniture")
public class FournitureController {
	@Autowired
	private FournitureService fouServ;

	public FournitureService getForServ() {
		return fouServ;
	}

	public void setForServ(FournitureService fouServ) {
		this.fouServ = fouServ;
	}

	String direction = "redirect:All";

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
	public String SuppFourniture(@ModelAttribute("fourniture") Fourniture fourniture) {
		fouServ.SupprimerFournitureService(fourniture);
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
