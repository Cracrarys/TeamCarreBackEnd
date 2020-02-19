package com.example.demo.restcontroller;

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

import com.example.demo.entity.DocumentRH;
import com.example.demo.entity.Employe;
import com.example.demo.service.DocumentService;
import com.example.demo.service.EmployeService;
@CrossOrigin
@RestController
@RequestMapping(value="/documentRestController")
public class DocumentRestController {

	@Autowired
	DocumentService docser;
	
	@Autowired
	EmployeService empser;
	
	public DocumentService getDocser() {
		return docser;
	}

	public void setDocser(DocumentService docser) {
		this.docser = docser;
	}
	
	public EmployeService getEmpser() {
		return empser;
	}

	public void setEmpser(EmployeService empser) {
		this.empser = empser;
	}
	
	@RequestMapping(value="/ajout/{idemp}", method=RequestMethod.POST)
	public void ajoutDocRH(@RequestBody DocumentRH docRH, @PathVariable String idemp) {
		Employe emp = empser.getByIdEmploye(Long.parseLong(idemp));
		docRH.setEmploye(emp);
		docser.ajoutDocumentService(docRH);
	}
	
	@RequestMapping(value="/supprimer/{idDoc}", method=RequestMethod.DELETE)
	public void supprDocRHId(@PathVariable String idDoc) {
		List<Employe> lstEmp = empser.getAllEmploye();
		List<DocumentRH> lstDoc = docser.getAllDocument();
		
		DocumentRH doc = docser.getByIdDocument(Long.parseLong(idDoc));
		lstDoc.remove(doc);
		docser.supprimerDocumentService(doc);
		
		for(DocumentRH docRH : lstDoc) {
			docser.ajoutDocumentService(docRH);
		}
		
		for(Employe emp : lstEmp) {
			List<DocumentRH> lstDocRH = emp.getDocument();
			lstDocRH.remove(doc);
			emp.setDocument(lstDocRH);
			empser.ajoutEmployeService(emp);
		}
	}
	
	@RequestMapping(value="/getAll", method=RequestMethod.GET)
	public ResponseEntity<Object> getAllDoc(){
		return new ResponseEntity<> (docser.getAllDocument(),HttpStatus.OK);
	}
	
	@RequestMapping(value="/getbyid/{id}", method=RequestMethod.GET)
	public DocumentRH getDocumentId(@PathVariable("id") String id){
		return docser.getByIdDocument(Long.parseLong(id));
	}
	
}
