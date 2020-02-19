package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.FormulaireIDAO;
import com.example.demo.entity.FormulaireEmprunt;

@Service
public class FormulaireService {
	@Autowired
	private FormulaireIDAO forDAO;

	public FormulaireIDAO getForDAO() {
		return forDAO;
	}

	public void setForDAO(FormulaireIDAO forDAO) {
		this.forDAO = forDAO;
	}

	public void AjoutFormulaireService(FormulaireEmprunt form) {
		forDAO.save(form);
	}

	public void SupprimerFormulaireService(FormulaireEmprunt form) {
		forDAO.delete(form);
	}

	public FormulaireEmprunt GetByIdFormulaire(Long idFormulaire) {
		return forDAO.getOne(idFormulaire);
	}

	public List<FormulaireEmprunt> GetAllFormulaire() {
		return forDAO.findAll();
	}
	public List<FormulaireEmprunt> getAllFormulaire(Boolean bool){
		List<FormulaireEmprunt> lstform = forDAO.findAll();
		if (bool!=null) {
			List<FormulaireEmprunt> lstF = new ArrayList<>();
			ListIterator<FormulaireEmprunt> lstIt = lstform.listIterator();
			while (lstIt.hasNext()) {
				FormulaireEmprunt form = lstIt.next();
				if (form.isDemandeValidee()) {
					lstF.add(form);
				}
			}
			return lstF;
		}else {
			return lstform;
		}
	}

	public void UpdateFormulaireService(FormulaireEmprunt form) {
		forDAO.saveAndFlush(form);
	}
	
	public List<FormulaireEmprunt> getFormulaireByName(String name){
		List<FormulaireEmprunt> lstform = forDAO.findAll();
		if (name!=null) {
			List<FormulaireEmprunt> lstF = new ArrayList<>();
			ListIterator<FormulaireEmprunt> lstIt = lstform.listIterator();
			while (lstIt.hasNext()) {
				FormulaireEmprunt form = lstIt.next();
				if (form.getFourniture().getNomFourniture().contains(name)) {
					lstF.add(form);
				}
			}
			return lstF;
		}else {
			return lstform;
		}
	}
	public List<FormulaireEmprunt> getAllFormulaire2 (Boolean bool){
		List<FormulaireEmprunt> lstform = forDAO.findAll();
		if (bool!=null) {
			List<FormulaireEmprunt> lstF = new ArrayList<>();
			ListIterator<FormulaireEmprunt> lstIt = lstform.listIterator();
			while (lstIt.hasNext()) {
				FormulaireEmprunt form = lstIt.next();
				if (!form.isDemandeValidee()) {
					lstF.add(form);
				}
			}
			return lstF;
		}else {
			return lstform;
		}
	}
}
