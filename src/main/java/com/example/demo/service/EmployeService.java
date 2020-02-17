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
	
	public List<Employe> getEmployeByName(String name){
		List<Employe> lstEmp = empDAO.findAll();
		if (name!=null) {
			List<Employe> lstF = new ArrayList<>();
			ListIterator<Employe> lstIt = lstEmp.listIterator();
			while (lstIt.hasNext()) {
				Employe emp = lstIt.next();
				if (emp.getNomEmploye().contains(name)) {
					lstF.add(emp);
				}
			}
			return lstF;
		}else {
			return lstEmp;
		}
	}
}
