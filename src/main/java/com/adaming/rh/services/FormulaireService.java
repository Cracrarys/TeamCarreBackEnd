package com.adaming.rh.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adaming.rh.dao.FormulaireIDAO;
import com.adaming.rh.entities.FormulaireEmprunt;

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

	public void UpdateFormulaireService(FormulaireEmprunt form) {
		forDAO.saveAndFlush(form);
	}
}
