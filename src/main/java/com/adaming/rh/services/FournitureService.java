package com.adaming.rh.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adaming.rh.dao.FournitureIDAO;
import com.adaming.rh.entities.Fourniture;

@Service
public class FournitureService {
	@Autowired
	private FournitureIDAO fourDAO;

	public FournitureIDAO getForDAO() {
		return fourDAO;
	}

	public void setForDAO(FournitureIDAO fourDAO) {
		this.fourDAO = fourDAO;
	}

	public void AjoutFournitureService(Fourniture fourniture) {
		fourDAO.save(fourniture);
	}

	public void SupprimerFournitureService(Fourniture fourniture) {
		fourDAO.delete(fourniture);
	}

	public Fourniture GetByIdFourniture(Long idFourniture) {
		return fourDAO.getOne(idFourniture);
	}

	public List<Fourniture> GetAllFourniture() {
		return fourDAO.findAll();
	}

	public void UpdateFournitureService(Fourniture fourniture) {
		fourDAO.saveAndFlush(fourniture);
	}
}
