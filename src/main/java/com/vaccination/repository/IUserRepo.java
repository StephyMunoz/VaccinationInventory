package com.vaccination.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vaccination.model.UserEmp;

public interface IUserRepo extends JpaRepository<UserEmp, Integer> {
	public UserEmp findByUsername(String username);

	// UserEmp getUserEmpByUsername(String username);

//	@Query("select u from UserEmp u where u.username = :username")
//	UserEmp getUserEmpByUsername(String username);

}