package com.vaccination.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vaccination.model.Employee;
import com.vaccination.repository.IAdminRepo;

@Service
public class EmployeeService {

	@Autowired
	private IAdminRepo repo;

	public Employee getById(int id) {
		return repo.getById(id);
	}
}
