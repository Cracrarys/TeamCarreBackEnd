package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Arrays;
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

import com.example.demo.entity.DocumentRH;
import com.example.demo.entity.Employe;
import com.example.demo.service.DocumentService;
import com.example.demo.service.EmployeService;

@Controller
@RequestMapping(value = "/Document")
public class DocumentController {
	@Autowired
	private DocumentService docServ;

	@Autowired

	private EmployeService empServ;
	

	public DocumentService getDocServ() {
		return docServ;
	}

	public void setDocServ(DocumentService docServ) {
		this.docServ = docServ;
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
		
		return "document";
	}
	@RequestMapping(value = "/find")
	public String find() {
		
		return "documentfind";
	}
	
	@RequestMapping(value = "/Ajout", method = RequestMethod.POST)
	public String AjoutDocumentRH(@ModelAttribute("document") DocumentRH document, Employe emp, ServletRequest req) {
//		List<Employe> listE = new ArrayList<Employe>();
//		List<String> listS = new ArrayList<String>();
//		listS = Arrays.asList(req.getParameterValues("empall"));
//		for(String stri: listS) listE.add(empServ.GetByIdEmploye(Long.parseLong(stri)));
//		document.setEmploye(emp);
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
//		model.addAttribute("listeEmploye", empServ.GetAllEmploye());
		return "documentall";

	}

	@RequestMapping(value = "/Chercher", method = RequestMethod.GET)
	public String getByIdDocumentRH(@ModelAttribute("document") DocumentRH document, ModelMap model) {
		model.addAttribute("leDocumentRH", docServ.GetByIdDocument(document.getIdDocument()));
		return "ledocument";

	}
}
