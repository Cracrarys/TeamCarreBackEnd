package com.adaming.rh.controller;

import javax.servlet.ServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.ModelAndView;

import com.adaming.rh.entities.DocumentRH;
import com.adaming.rh.services.DocumentService;

@Controller
@RequestMapping(value = "/Document")
public class DocumentController {
	@Autowired
	private DocumentService docServ;

	public DocumentService getDocServ() {
		return docServ;
	}

	public void setDocServ(DocumentService docServ) {
		this.docServ = docServ;
	}

	String direction = "redirect:All";

	@RequestMapping(value = "/Ajout", method = RequestMethod.POST)
	public String AjoutDocumentRH(@ModelAttribute("document") DocumentRH document, ServletRequest req) {
		docServ.AjoutDocumentService(document);
		return direction;

	}

	@RequestMapping(value = "/Update", method = RequestMethod.POST)
	public ModelAndView UpdateDocumentRH(@ModelAttribute("document") DocumentRH document) {
		docServ.UpdateDocumentService(document);
		return new ModelAndView(direction);
	}

	@RequestMapping(value = "/Supprimer", method = RequestMethod.POST)
	public String SuppDocumentRH(@ModelAttribute("document") DocumentRH document) {
		docServ.SupprimerDocumentService(document);
		return direction;

	}

	@RequestMapping(value = "/All", method = RequestMethod.GET)
	public String getAllDocumentRH(@ModelAttribute("document") DocumentRH document, ModelMap model) {
		model.addAttribute("listeDocumentRH", docServ.GetAllDocument());
		return "document";

	}

	@RequestMapping(value = "/Chercher", method = RequestMethod.GET)
	public String getByIdDocumentRH(@ModelAttribute("document") DocumentRH document, ModelMap model) {
		model.addAttribute("leDocumentRH", docServ.GetByIdDocument(document.getIdDocument()));
		return "ledocument";

	}
}
