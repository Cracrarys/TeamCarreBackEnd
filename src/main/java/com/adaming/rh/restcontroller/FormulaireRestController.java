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

import com.adaming.rh.entities.Employe;
import com.adaming.rh.entities.FormulaireEmprunt;
import com.adaming.rh.entities.Fourniture;
import com.adaming.rh.services.EmployeService;
import com.adaming.rh.services.FormulaireService;
import com.adaming.rh.services.FournitureService;

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
		Employe emp = empser.GetByIdEmploye(Long.parseLong(idEmp));
		Fourniture four = fourser.GetByIdFourniture(Long.parseLong(idFour));
		if (four.getQuantiteDisponible()>0) {
			if (four.isConsommable()) {
				four.setQuantiteTotale(four.getQuantiteTotale()-1);
			}
			four.setQuantiteDisponible(four.getQuantiteDisponible()-1);
		}
		form.setEmploye(emp);
		form.setFourniture(four);
		formser.AjoutFormulaireService(form);
	}
	
	@RequestMapping(value="/getAll", method=RequestMethod.GET)
	public ResponseEntity<Object> getAllFormulaire(){
		return new ResponseEntity<> (formser.GetAllFormulaire(),HttpStatus.OK);
	}
	
	@RequestMapping(value="/getbyid/{id}", method=RequestMethod.GET)
	public FormulaireEmprunt getFormulaireId(@PathVariable("id") String id){
		return formser.GetByIdFormulaire(Long.parseLong(id));
	}
	
	@RequestMapping(value="/supprimer/{id}", method=RequestMethod.DELETE)
	public void supprimerFormulaire(@PathVariable("id") String id) {
		List<FormulaireEmprunt> lstForm = formser.GetAllFormulaire();
		List<Employe> lstEmp = empser.GetAllEmploye();
		List<Fourniture> lstFour = fourser.GetAllFourniture();
		
		FormulaireEmprunt formu = formser.GetByIdFormulaire(Long.parseLong(id));
		lstForm.remove(formu);
		formser.SupprimerFormulaireService(formu);
		
		for (FormulaireEmprunt form : lstForm) {
			formser.AjoutFormulaireService(form);
		}
		
		for(Employe emp : lstEmp) {
			List<FormulaireEmprunt> lstFormulaire = emp.getFormulaire();
			lstFormulaire.remove(formu);
			emp.setFormulaire(lstFormulaire);
			empser.AjoutEmployeService(emp);
		}
		
		for(Fourniture four : lstFour) {
			List<FormulaireEmprunt> lstFormulaire = four.getFormulaire();
			lstFormulaire.remove(formu);
			four.setFormulaire(lstFormulaire);
			fourser.AjoutFournitureService(four);
		}
		
	}
	
}
