package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.EmployeIDAO;
import com.example.demo.entity.Employe;

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

	public void ajoutEmployeService(Employe empl) {
		empDAO.save(empl);
	}

	public void supprimerEmployeService(Employe empl) {
		empDAO.delete(empl);
	}

	public Employe getByIdEmploye(Long idEmploye) {
		return empDAO.getOne(idEmploye);
	}

	public List<Employe> getAllEmploye() {
		return empDAO.findAll();
	}

	public void updateEmployeService(Employe empl) {
		empDAO.saveAndFlush(empl);
	}

	public List<Employe> getEmployeByName(String name) {
		List<Employe> lstEmp = empDAO.findAll();
		if (name != null) {
			List<Employe> lstF = new ArrayList<>();
			ListIterator<Employe> lstIt = lstEmp.listIterator();
			while (lstIt.hasNext()) {
				Employe emp = lstIt.next();
				if (emp.getNomEmploye().contains(name)) {
					lstF.add(emp);
				}
			}
			return lstF;
		} else {
			return lstEmp;
		}
	}
}
