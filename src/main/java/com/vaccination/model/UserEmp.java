package com.vaccination.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;

import com.vaccination.Role;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
public class UserEmp {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(length = 40)
	private String username;

	@Column
	@Min(value = 6, message = "La contraseña debe contener al menos 6 caracteres")
	private String password;

	@OneToOne
	@JoinColumn(name = "employee_id")
	@Getter
	@Setter
	private Employee employee;

	@Enumerated(EnumType.STRING)
	private Role role;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}
