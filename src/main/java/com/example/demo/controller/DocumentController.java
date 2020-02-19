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

	@RequestMapping(value = "/init", method = RequestMethod.GET)
	public String init(ModelMap model) {
		model.addAttribute("listeEmployebis", empServ.GetAllEmploye());
		return "document";
	}

	@RequestMapping(value = "/Ajout", method = RequestMethod.POST)
	public String AjoutDocumentRH(@RequestParam("empID") String empID,
			@ModelAttribute("document") DocumentRH document) {
		Employe emp = empServ.GetByIdEmploye(Long.parseLong(empID));
		document.setEmploye(emp);
		docServ.AjoutDocumentService(document);
		return direction;

	}

	@RequestMapping(value = "/Update", method = RequestMethod.POST)
	public ModelAndView UpdateDocumentRH(@ModelAttribute("document") DocumentRH document) {
		docServ.UpdateDocumentService(document);
		return new ModelAndView(direction);
	}

	@RequestMapping(value = "/Supprimer", method = RequestMethod.POST)
	public String SuppDocumentRH(@RequestParam("docID") String docID) {
		List<Employe> lstEmp = empServ.GetAllEmploye();
		List<DocumentRH> lstDoc = docServ.GetAllDocument();

		DocumentRH doc = docServ.GetByIdDocument(Long.parseLong(docID));
		lstDoc.remove(doc);
		docServ.SupprimerDocumentService(doc);

		for (DocumentRH docRH : lstDoc) {
			docServ.AjoutDocumentService(docRH);
		}

		for (Employe emp : lstEmp) {
			List<DocumentRH> lstDocRH = emp.getDocument();
			lstDocRH.remove(doc);
			emp.setDocument(lstDocRH);
			empServ.AjoutEmployeService(emp);
		}
		return direction;

	}

	@RequestMapping(value = "/All", method = RequestMethod.GET)
	public String getAllDocumentRH(@ModelAttribute("document") DocumentRH document, Employe employe, ModelMap model) {
		model.addAttribute("listeDocumentRH", docServ.GetAllDocument());
		model.addAttribute("listeEmploye", empServ.GetAllEmploye());
		return "documentall";

	}

	@RequestMapping(value = "/Chercher", method = RequestMethod.GET)
	public String getByIdDocumentRH(@ModelAttribute("document") DocumentRH document, ModelMap model) {
		model.addAttribute("leDocumentRH", docServ.GetByIdDocument(document.getIdDocument()));
		return "ledocument";

	}
}
