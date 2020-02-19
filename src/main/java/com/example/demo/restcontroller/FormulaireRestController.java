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

import com.example.demo.entity.Employe;
import com.example.demo.entity.FormulaireEmprunt;
import com.example.demo.entity.Fourniture;
import com.example.demo.service.EmployeService;
import com.example.demo.service.FormulaireService;
import com.example.demo.service.FournitureService;

@CrossOrigin
@RestController
@RequestMapping(value="/formulaireRestController")
public class FormulaireRestController {

	@Autowired
	FormulaireService formser;
	
	@Autowired
	EmployeService empser;
	
	@Autowired
	FournitureService fourser;

	public FormulaireService getFormser() {
		return formser;
	}

	public void setFormser(FormulaireService formser) {
		this.formser = formser;
	}

	public EmployeService getEmpser() {
		return empser;
	}

	public void setEmpser(EmployeService empser) {
		this.empser = empser;
	}

	public FournitureService getFourser() {
		return fourser;
	}

	public void setFourser(FournitureService fourser) {
		this.fourser = fourser;
	}
	
	@RequestMapping(value="/ajout/{idEmp}/&/{idFour}", method=RequestMethod.POST)
	public void ajoutFormulaire(@RequestBody FormulaireEmprunt form,
			@PathVariable("idEmp") String idEmp, @PathVariable("idFour") String idFour) {
		Employe emp = empser.getByIdEmploye(Long.parseLong(idEmp));
		Fourniture four = fourser.getByIdFourniture(Long.parseLong(idFour));
		int quantite = form.getQuantite();
		if (four.getQuantiteDisponible()>=quantite && form.isDemandeValidee()) {
			if (four.isConsommable()) {
				four.setQuantiteTotale(four.getQuantiteTotale()-quantite);
			}
			four.setQuantiteDisponible(four.getQuantiteDisponible()-quantite);
		}else {
			form.setDemandeValidee(false);
		}
		form.setEmploye(emp);
		form.setFourniture(four);
		formser.ajoutFormulaireService(form);
	}
	
	@RequestMapping(value="/getAll", method=RequestMethod.GET)
	public ResponseEntity<Object> getAllFormulaire(){
		return new ResponseEntity<> (formser.getAllFormulaire(),HttpStatus.OK);
	}
	
	@RequestMapping(value="/getAllNonOk", method=RequestMethod.GET)
	public ResponseEntity<Object> getAllFormuNonOk(){
		return new ResponseEntity<> (formser.getFormulaireNOK(),HttpStatus.OK);
	}
	
	@RequestMapping(value="/getbyid/{id}", method=RequestMethod.GET)
	public FormulaireEmprunt getFormulaireId(@PathVariable("id") String id){
		return formser.getByIdFormulaire(Long.parseLong(id));
	}
	
	@RequestMapping(value="/supprimer/{id}", method=RequestMethod.DELETE)
	public void supprimerFormulaire(@PathVariable("id") String id) {
		List<FormulaireEmprunt> lstForm = formser.getAllFormulaire();
		List<Employe> lstEmp = empser.getAllEmploye();
		List<Fourniture> lstFour = fourser.getAllFourniture();
		
		FormulaireEmprunt formu = formser.getByIdFormulaire(Long.parseLong(id));
		lstForm.remove(formu);
		formser.supprimerFormulaireService(formu);
		
		for (FormulaireEmprunt form : lstForm) {
			formser.ajoutFormulaireService(form);
		}
		
		for(Employe emp : lstEmp) {
			List<FormulaireEmprunt> lstFormulaire = emp.getFormulaire();
			lstFormulaire.remove(formu);
			emp.setFormulaire(lstFormulaire);
			empser.ajoutEmployeService(emp);
		}
		
		for(Fourniture four : lstFour) {
			List<FormulaireEmprunt> lstFormulaire = four.getFormulaire();
			lstFormulaire.remove(formu);
			four.setFormulaire(lstFormulaire);
			fourser.ajoutFournitureService(four);
		}
		
	}
	
}
