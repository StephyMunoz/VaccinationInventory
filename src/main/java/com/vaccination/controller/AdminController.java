package com.vaccination.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vaccination.model.EmpInfo;
import com.vaccination.model.Employee;
import com.vaccination.repository.IAdminRepo;
import com.vaccination.repository.IEmpInfoRepo;
import com.vaccination.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class AdminController {

	@Autowired
	private IAdminRepo repo;
	
	@Autowired
	private IEmpInfoRepo inforepo;

	@Autowired
	EmployeeService employeeService;

	@GetMapping
	public List<Employee> list() {
		return repo.findAll();
	}

	@PostMapping("/admin/register")
	public Employee insert(@RequestBody Employee emp) {

		try {
			repo.save(emp);
			return emp;

		} catch (Exception e) {
			return null;
		}
	}

	@PutMapping("/admin/update/{id}")
	public Employee update(@PathVariable("id") Integer id, @RequestBody Employee emp) {
		Employee employee = employeeService.getById(id);

		employee.setName(emp.getName());
		employee.setEmail(emp.getEmail());
		employee.setIdNumber(emp.getIdNumber());
		employee.setEmail(emp.getEmail());

		return repo.save(employee);
	}

	@DeleteMapping(value = "/admin/delete/{id}")
	public Employee delete(@PathVariable("id") Integer id) {
		repo.deleteById(id);
		return null;
	}
	
	@GetMapping(value = "/admin/filter/{vaccinated}")
	public List<EmpInfo> filterByVaccinatedEmployees(@PathVariable("vaccinated") Boolean vaccinatedEmp){
		List<EmpInfo> list = inforepo.findAll();
		List<EmpInfo> vaccinated = new ArrayList();
		
		for(EmpInfo emp : list) {
			if(emp.isVaccinated() == vaccinatedEmp) {
				vaccinated.add(emp);
			}
		}
		
		return vaccinated;
	}
	
	@GetMapping(value = "/admin/kind/{vaccine}")
	public List<EmpInfo> filterByNoVaccinatedEmployees(@PathVariable("vaccine") String vaccine){
		
//		if(!vaccine.toLowerCase().equals("sputnik") || !vaccine.toLowerCase().equals("astraZeneca") || !vaccine.toLowerCase().equals("pfizer") || !vaccine.toLowerCase().equals("jhonson&jhonson")) {
//			return null;
//		}
		List<EmpInfo> list = inforepo.findAll();
		List<EmpInfo> vaccinated = new ArrayList();
		
		for(EmpInfo emp : list) {
			if(emp.getVaccine().toLowerCase().equals(vaccine)) {
				vaccinated.add(emp);
			}
		}
		
		return vaccinated;
	}
	
	@GetMapping(value = "/admin/date/{dateFrom}/{dateTo}")
	public List<EmpInfo> filterByNoVaccinatedEmployees(@PathVariable("date") Date dateFrom, @PathVariable("date") Date dateTo){
		
		List<EmpInfo> list = inforepo.findAll();
		List<EmpInfo> vaccinated = new ArrayList();
		
		for(EmpInfo emp : list) {
			if(emp.getVaccinationDate().before(dateTo) && emp.getVaccinationDate().after(dateFrom)) {
				vaccinated.add(emp);
			}
		}
		
		return vaccinated;
	}
}
