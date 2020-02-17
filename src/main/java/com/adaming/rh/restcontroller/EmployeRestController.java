package com.adaming.rh.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adaming.rh.entities.DocumentRH;
import com.adaming.rh.entities.Employe;
import com.adaming.rh.entities.FormulaireEmprunt;
import com.adaming.rh.entities.Fourniture;
import com.adaming.rh.services.DocumentService;
import com.adaming.rh.services.EmployeService;
import com.adaming.rh.services.FormulaireService;
import com.adaming.rh.services.FournitureService;

@CrossOrigin
@RestController
@RequestMapping(value="/employeRestController")
public class EmployeRestController {

	@Autowired
	EmployeService empser;
	
	@Autowired
	DocumentService docser;
	
	@Autowired
	FormulaireService formser;
	
	@Autowired
	FournitureService fourser;
	
	public EmployeService getEmpser() {
		return empser;
	}

	public void setEmpser(EmployeService empser) {
		this.empser = empser;
	}

	public DocumentService getDocser() {
		return docser;
	}

	public void setDocser(DocumentService docser) {
		this.docser = docser;
	}

	public FormulaireService getFormser() {
		return formser;
	}

	public void setFormser(FormulaireService formser) {
		this.formser = formser;
	}

	public FournitureService getFourser() {
		return fourser;
	}

	public void setFourser(FournitureService fourser) {
		this.fourser = fourser;
	}
	
	@RequestMapping(value="/ajout", method=RequestMethod.POST)
	public void ajoutEmploye(@RequestBody Employe emp) {
		empser.AjoutEmployeService(emp);
	}
	
	@RequestMapping(value="/getAll", method=RequestMethod.GET)
	public ResponseEntity<Object> getAllEmp(){
		return new ResponseEntity<> (empser.GetAllEmploye(),HttpStatus.OK);
	}
	
	@RequestMapping(value="/getbyid/{id}", method=RequestMethod.GET)
	public Employe getEmployeId(@PathVariable("id") String id){
		return empser.GetByIdEmploye(Long.parseLong(id));
	}
	
	@RequestMapping(value="/supprimer/{id}", method=RequestMethod.DELETE)
	public void supprimerEmploye(@PathVariable("id") String id) {
		List<Employe> lstEmp = empser.GetAllEmploye();
		List<DocumentRH> lstDoc = docser.GetAllDocument();
		List<FormulaireEmprunt> lstForm = formser.GetAllFormulaire();
		List<Fourniture> lstFour = fourser.GetAllFourniture();
		
		Employe emp = empser.GetByIdEmploye(Long.parseLong(id));
		lstEmp.remove(emp);
		empser.SupprimerEmployeService(emp);
		
		for (Employe empl : lstEmp) {
			empser.AjoutEmployeService(empl);
		}
		
		for (DocumentRH doc : lstDoc) {
			Employe empl = doc.getEmploye();
			if (empl.getIdEmploye() == emp.getIdEmploye()) {
				doc.setEmploye(null);
			}
			docser.AjoutDocumentService(doc);
		}
		
		for (FormulaireEmprunt form : lstForm) {
			Employe empl = form.getEmploye();
			if (empl.getIdEmploye() == emp.getIdEmploye()) {
				form.setEmploye(null);
			}
			formser.AjoutFormulaireService(form);
		}
		
		for (Fourniture four : lstFour) {
			List<Employe> lstEmploye = four.getEmploye();
			lstEmploye.remove(emp);
			four.setEmploye(lstEmploye);
			fourser.AjoutFournitureService(four);
		}
	}
	
}
