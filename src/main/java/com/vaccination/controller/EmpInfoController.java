package com.vaccination.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vaccination.model.EmpInfo;
import com.vaccination.model.Employee;
import com.vaccination.repository.IEmpInfoRepo;
import com.vaccination.service.EmpInformationService;
import com.vaccination.service.EmployeeService;
import com.vaccination.service.UserService;

@RestController
@RequestMapping("/api")
public class EmpInfoController {

	@Autowired
	private IEmpInfoRepo repo;

	@Autowired
	EmployeeService employeeService;

	@Autowired
	EmpInformationService empInfoService;

	@Autowired
	UserService userService;

	@PersistenceContext
	EntityManager entityManager;

	@PostMapping("/information/{id}")
	public EmpInfo saveInformation(@RequestBody EmpInfo empInfo, @PathVariable("id") Integer id) {

		Employee emp = employeeService.getById(id);
		
		if(emp == null) {
			return null;
		}

		empInfo.setAddress(empInfo.getAddress());
		empInfo.setDateOfBirth(empInfo.getDateOfBirth());
		empInfo.setPhonenumber(empInfo.getPhonenumber());
		empInfo.setVaccinated(empInfo.isVaccinated());
		empInfo.setDoses(empInfo.getDoses());
		empInfo.setVaccinationDate(empInfo.getVaccinationDate());
		empInfo.setVaccine(empInfo.getVaccine());
		empInfo.setEmployee(emp);

		return repo.save(empInfo);

	}

	@PutMapping("/updateinfo/{id}")
	public EmpInfo updateInformation(@RequestBody EmpInfo emp, @PathVariable("id") Integer id) {

		EmpInfo empInfo = empInfoService.getById(id);

		empInfo.setAddress(emp.getAddress());
		empInfo.setDateOfBirth(emp.getDateOfBirth());
		empInfo.setPhonenumber(emp.getPhonenumber());
		empInfo.setVaccinated(emp.isVaccinated());
		empInfo.setDoses(emp.getDoses());
		empInfo.setVaccinationDate(emp.getVaccinationDate());
		empInfo.setVaccine(emp.getVaccine());
		empInfo.setEmployee(emp.getEmployee());

		return repo.save(empInfo);

	}
}
