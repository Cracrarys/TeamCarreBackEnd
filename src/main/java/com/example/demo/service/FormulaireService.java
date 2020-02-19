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

	public void ajoutFormulaireService(FormulaireEmprunt form) {
		forDAO.save(form);
	}

	public void updateFormulaireService(FormulaireEmprunt form) {
		forDAO.saveAndFlush(form);
	}

	public void supprimerFormulaireService(FormulaireEmprunt form) {
		forDAO.delete(form);
	}

	public FormulaireEmprunt getByIdFormulaire(Long idFormulaire) {
		return forDAO.getOne(idFormulaire);
	}

	public List<FormulaireEmprunt> getFormulaireByName(String name) {
		List<FormulaireEmprunt> lstform = forDAO.findAll();
		if (name != null) {
			List<FormulaireEmprunt> lstF = new ArrayList<>();
			ListIterator<FormulaireEmprunt> lstIt = lstform.listIterator();
			while (lstIt.hasNext()) {
				FormulaireEmprunt form = lstIt.next();
				if (form.getFourniture().getNomFourniture().contains(name)) {
					lstF.add(form);
				}
			}
			return lstF;
		} else {
			return lstform;
		}
	}
	
	public List<FormulaireEmprunt> getFormulaireNOK() {
		List<FormulaireEmprunt> lstform = forDAO.findAll();
		List<FormulaireEmprunt> lstF = new ArrayList<>();
		ListIterator<FormulaireEmprunt> lstIt = lstform.listIterator();
		while (lstIt.hasNext()) {
			FormulaireEmprunt form = lstIt.next();
			if (!form.isDemandeValidee()) {
				lstF.add(form);
			}
		}
		return lstF;
	}

	public List<FormulaireEmprunt> getAllFormulaire() {
		return forDAO.findAll();
	}

	public List<FormulaireEmprunt> getAllFormulaireTrue(Boolean bool) {
		List<FormulaireEmprunt> lstform = forDAO.findAll();
		if (bool != null) {
			List<FormulaireEmprunt> lstF = new ArrayList<>();
			ListIterator<FormulaireEmprunt> lstIt = lstform.listIterator();
			while (lstIt.hasNext()) {
				FormulaireEmprunt form = lstIt.next();
				if (form.isDemandeValidee()) {
					lstF.add(form);
				}
			}
			return lstF;
		} else {
			return lstform;
		}
	}

	public List<FormulaireEmprunt> getAllFormulaireFalse(Boolean bool) {
		List<FormulaireEmprunt> lstform = forDAO.findAll();
		if (bool != null) {
			List<FormulaireEmprunt> lstF = new ArrayList<>();
			ListIterator<FormulaireEmprunt> lstIt = lstform.listIterator();
			while (lstIt.hasNext()) {
				FormulaireEmprunt form = lstIt.next();
				if (!form.isDemandeValidee()) {
					lstF.add(form);
				}
			}
			return lstF;
		} else {
			return lstform;
		}
	}
}
