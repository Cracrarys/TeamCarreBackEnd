package com.adaming.rh;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.adaming.rh.entities.Employe;
import com.adaming.rh.services.EmployeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class TestDaoEmploye {
	@Autowired
	private EmployeService empServ;

	Employe empl = new Employe();

	public EmployeService getEmpServ() {
		return empServ;
	}

	public void setEmpServ(EmployeService empServ) {
		this.empServ = empServ;
	}

	@Before
	public void setUp() {
		empl.setIdEmploye(11L);
		empl.setNomEmploye("nomEmploye");
		empl.setPrenomEmploye("prenomEmploye");
	}

	@Test
	public void AjoutEmploye() {
		empServ.AjoutEmployeService(empl);
		Employe emplfound = empServ.GetByIdEmploye(11L);
		assertEquals(emplfound.toString(), empl.toString());
	}
}
