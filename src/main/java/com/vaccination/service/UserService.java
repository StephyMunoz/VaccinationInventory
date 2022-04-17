package com.vaccination.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.vaccination.model.UserEmp;
import com.vaccination.repository.IUserRepo;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private IUserRepo repo;

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		UserEmp userEmp = repo.findByUsername(username);

		List<GrantedAuthority> roles = new ArrayList<>();
		roles.add(new SimpleGrantedAuthority("ROLE_USER"));

		UserDetails userDet = new User(userEmp.getUsername(), userEmp.getPassword(), roles);

		return userDet;
	}

}
