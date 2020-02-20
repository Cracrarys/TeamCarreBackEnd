package com.example.demo.controller;

import java.util.Collections;
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
		List<Employe> listeEmp = empServ.getAllEmploye();
		Collections.sort(listeEmp, Employe.empNameComparator);
		model.addAttribute("listeEmployebis", listeEmp);
		return "document";
	}

	@RequestMapping(value = "/find")
	public String find() {

		return "documentfind";
	}

	@RequestMapping(value = "/Ajout", method = RequestMethod.POST)
	public String ajoutDocumentRH(@RequestParam("empID") String empID,
			@ModelAttribute("document") DocumentRH document) {
		Employe emp = empServ.getByIdEmploye(Long.parseLong(empID));
		document.setEmploye(emp);
		docServ.ajoutDocumentService(document);
		return direction;

	}

	@RequestMapping(value = "/Update", method = RequestMethod.POST)
	public ModelAndView updateDocumentRH(@RequestParam("empID") String empID,
			@ModelAttribute("document") DocumentRH document) {
		Employe emp = empServ.getByIdEmploye(Long.parseLong(empID));
		document.setEmploye(emp);
		docServ.ajoutDocumentService(document);
		return new ModelAndView(direction);
	}

	@RequestMapping(value = "/Supprimer", method = RequestMethod.POST)
	public String suppDocumentRH(@RequestParam("docID") String docID) {
		List<Employe> lstEmp = empServ.getAllEmploye();
		List<DocumentRH> lstDoc = docServ.getAllDocument();

		DocumentRH doc = docServ.getByIdDocument(Long.parseLong(docID));
		lstDoc.remove(doc);
		docServ.ajoutDocumentService(doc);

		for (DocumentRH docRH : lstDoc) {
			docServ.ajoutDocumentService(docRH);
		}

		for (Employe emp : lstEmp) {
			List<DocumentRH> lstDocRH = emp.getDocument();
			lstDocRH.remove(doc);
			emp.setDocument(lstDocRH);
			empServ.ajoutEmployeService(emp);
		}
		return direction;

	}

	@RequestMapping(value = "/All", method = RequestMethod.GET)
	public String getAllDocumentRH(@ModelAttribute("document") DocumentRH document, Employe employe, ModelMap model) {
		model.addAttribute("listeDocumentRH", docServ.getAllDocument());
		model.addAttribute("listeEmploye", empServ.getAllEmploye());
		return "documentall";

	}

	@RequestMapping(value = "/ChercherByID", method = RequestMethod.GET)
	public String getByIdDocument(@RequestParam("docID") String docID, ModelMap model) {
		DocumentRH doc = docServ.getByIdDocument(Long.parseLong(docID));
		model.addAttribute("leDocumentRH", doc);
		return "ledocument";

	}

	@RequestMapping(value = "/ChercherByName", method = RequestMethod.GET)
	public String getByNameDocument(@RequestParam("docNAME") String docNAME, ModelMap model) {
		List<DocumentRH> listeDoc = docServ.getDocByName(docNAME);
		model.addAttribute("listDocument", listeDoc);
		return "ledocument2";

	}
}
