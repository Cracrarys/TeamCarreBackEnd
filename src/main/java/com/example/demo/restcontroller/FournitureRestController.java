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
@RequestMapping(value="/fournitureRestController")
public class FournitureRestController {

	@Autowired
	FournitureService fourser;
	
	@Autowired
	EmployeService empser;
	
	@Autowired
	FormulaireService formser;

	public FournitureService getFourser() {
		return fourser;
	}

	public void setFourser(FournitureService fourser) {
		this.fourser = fourser;
	}

	public EmployeService getEmpser() {
		return empser;
	}

	public void setEmpser(EmployeService empser) {
		this.empser = empser;
	}

	public FormulaireService getFormser() {
		return formser;
	}

	public void setFormser(FormulaireService formser) {
		this.formser = formser;
	}
	
	@RequestMapping(value="/ajout", method=RequestMethod.POST)
	public void ajoutFourniture(@RequestBody Fourniture four) {
		fourser.ajoutFournitureService(four);
	}
	
	@RequestMapping(value="/getAll", method=RequestMethod.GET)
	public ResponseEntity<Object> getAllFourniture(){
		return new ResponseEntity<> (fourser.getAllFourniture(),HttpStatus.OK);
	}
	
	@RequestMapping(value="/getbyid/{id}", method=RequestMethod.GET)
	public Fourniture getFournitureId(@PathVariable("id") String id){
		return fourser.getByIdFourniture(Long.parseLong(id));
	}
	
	@RequestMapping(value="/supprimer/{id}", method=RequestMethod.DELETE)
	public void supprimerEmploye(@PathVariable("id") String id) {
		List<Employe> lstEmp = empser.getAllEmploye();
		List<FormulaireEmprunt> lstForm = formser.getAllFormulaire();
		List<Fourniture> lstFour = fourser.getAllFourniture();
		
		Fourniture four = fourser.getByIdFourniture(Long.parseLong(id));
		lstFour.remove(four);
		fourser.supprimerFournitureService(four);
		
		for (Fourniture fourn : lstFour) {
			fourser.ajoutFournitureService(fourn);
		}
		for (Employe emp : lstEmp) {
			List<Fourniture> lstFourni = emp.getFourniture();
			lstFourni.remove(four);
			emp.setFourniture(lstFourni);
			empser.ajoutEmployeService(emp);
		}
		for (FormulaireEmprunt form : lstForm) {
			Fourniture fourn = form.getFourniture();
			if (fourn.getIdFourniture()==four.getIdFourniture()) {
				form.setFourniture(null);
			}
			formser.ajoutFormulaireService(form);
		}
	}
}
