package com.vaccination.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vaccination.Role;
import com.vaccination.model.AuthenticationResponse;
import com.vaccination.model.Employee;
import com.vaccination.model.UserEmp;
import com.vaccination.repository.IUserRepo;
import com.vaccination.service.EmployeeService;
import com.vaccination.service.JWTService;
import com.vaccination.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	EmployeeService employeeService;

	@Autowired
	UserService userService;

	@PersistenceContext
	EntityManager entityManager;

	Role role;

	@Autowired
	private IUserRepo rep;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JWTService jwtService;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@PostMapping("/credentials/{id}")
	public UserEmp createCredentials(@RequestBody UserEmp user, @PathVariable("id") Integer id) {

		Employee emp = employeeService.getById(id);

		user.setRole(Role.ROLE_USER);
		user.setUsername(user.getUsername());
		user.setPassword(encoder.encode(user.getPassword()));
		user.setEmployee(emp);

		return rep.save(user);
	}

	@PostMapping("/auth")
	public AuthenticationResponse createToken(@RequestBody UserEmp userEmp) throws Exception {
		try {
			UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
					userEmp.getUsername(), userEmp.getPassword());
			authenticationManager.authenticate(authentication);
		} catch (BadCredentialsException e) {
			throw new Exception("Usuario o contraseña incorrecta", e);
		}
		UserDetails userDetails = userService.loadUserByUsername(userEmp.getUsername());
		String token = jwtService.createToken(userDetails);
		UserEmp userAutenticated = rep.findByUsername(userEmp.getUsername());
		AuthenticationResponse auth = new AuthenticationResponse();
		auth.setToken(token);
		auth.setUser(userAutenticated);
		return auth;
	}

}
