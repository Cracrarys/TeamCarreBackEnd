package com.adaming.rh.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adaming.rh.dao.EmployeIDAO;
import com.adaming.rh.entities.Employe;

@Service
public class EmployeService {
	@Autowired
	private EmployeIDAO empDAO;

	public EmployeIDAO getEmpDAO() {
		return empDAO;
	}

	public void setEmpDAO(EmployeIDAO empDAO) {
		this.empDAO = empDAO;
	}

	public void AjoutEmployeService(Employe empl) {
		empDAO.save(empl);
	}

	public void SupprimerEmployeService(Employe empl) {
		empDAO.delete(empl);
	}

	public Employe GetByIdEmploye(Long idEmploye) {
		return empDAO.getOne(idEmploye);
	}

	public List<Employe> GetAllEmploye() {
		return empDAO.findAll();
	}

	public void UpdateEmployeService(Employe empl) {
		empDAO.saveAndFlush(empl);
	}
}
