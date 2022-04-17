package com.vaccination.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vaccination.model.Employee;

public interface IAdminRepo extends JpaRepository<Employee, Integer> {
	Employee getEmployeeById(int id);
}
