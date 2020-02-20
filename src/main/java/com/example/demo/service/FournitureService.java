package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.FournitureIDAO;
import com.example.demo.entity.Fourniture;

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

	public void ajoutFournitureService(Fourniture fourniture) {
		fourDAO.save(fourniture);
	}

	public void supprimerFournitureService(Fourniture fourniture) {
		fourDAO.delete(fourniture);
	}

	public Fourniture getByIdFourniture(Long idFourniture) {
		return fourDAO.getOne(idFourniture);
	}

	public List<Fourniture> getAllFourniture() {
		return fourDAO.findAll();
	}

	public void updateFournitureService(Fourniture fourniture) {
		fourDAO.saveAndFlush(fourniture);
	}
	
	public List<Fourniture> getFormulaireByName(String name){
		List<Fourniture> lstfour = fourDAO.findAll();
		if (name!=null) {
			List<Fourniture> lstF = new ArrayList<>();
			ListIterator<Fourniture> lstIt = lstfour.listIterator();
			while (lstIt.hasNext()) {
				Fourniture form = lstIt.next();
				if (form.getNomFourniture().contains(name)) {
					lstF.add(form);
				}
			}
			return lstF;
		}else {
			return lstfour;
		}
	}
	public List<Fourniture> getFournitureByName(String name){
		List<Fourniture> lstfour = fourDAO.findAll();
		if (name!=null) {
			List<Fourniture> lstF = new ArrayList<>();
			ListIterator<Fourniture> lstIt = lstfour.listIterator();
			while (lstIt.hasNext()) {
				Fourniture form = lstIt.next();
				if (form.getNomFourniture().contains(name)) {
					lstF.add(form);
				}
			}
			return lstF;
		}else {
			return lstfour;
		}
	}
}
