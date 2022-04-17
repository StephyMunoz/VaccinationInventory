package com.vaccination.controller;

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

import com.vaccination.model.Employee;
import com.vaccination.repository.IAdminRepo;
import com.vaccination.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class VaccinationController {

	@Autowired
	private IAdminRepo repo;

	@Autowired
	EmployeeService employeeService;

	@GetMapping
	public List<Employee> list() {
		return repo.findAll();
	}

	@PostMapping("admin/register")
	public Employee insert(@RequestBody Employee emp) {

		try {
			repo.save(emp);
			return emp;

		} catch (Exception e) {
			return null;
		}
	}

	@PutMapping("admin/update/{id}")
	public Employee update(@PathVariable("id") Integer id, @RequestBody Employee emp) {
		Employee employee = employeeService.getById(id);

		employee.setName(emp.getName());
		employee.setEmail(emp.getEmail());
		employee.setIdNumber(emp.getIdNumber());
		employee.setEmail(emp.getEmail());

		return repo.save(employee);
	}

	@DeleteMapping(value = "admin/delete/{id}")
	public Employee delete(@PathVariable("id") Integer id) {
		repo.deleteById(id);
		return null;
	}
}
