package com.vaccination.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "employees")
public class Employee {
	@Autowired(required = false)

	@Id
	@Getter
	@Setter
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotEmpty(message = "El campo cédula debe ser llenado")
	@Pattern (regexp = "^(\\d{10})$", message = "La cédula debe contener 10 números")
	@Column(length = 10)
	private String idNumber;

	@NotEmpty(message = "El campo nombre debe ser llenado")
	@Column(length = 80)
	@Pattern (regexp = "[A-Za-z]+", message = "El nombre no puede contener caracteres especiales")
	private String name;

	@NotEmpty(message = "El campo Apellido debe ser llenado")
	@Column(length = 80)
	@Pattern (regexp = "[A-Za-z]+", message = "El apellido no puede contener caracteres especiales")
	private String lastname;

	@NotEmpty(message = "El campo email debe ser llenado")
	@Email(message = "El formato de correo electrónico es inválido")
	@Column(length = 30)
	@Getter
	@Setter
	private String email;

	@OneToOne(mappedBy = "employee")
	@Getter
	@Setter
	private UserEmp user;

	@OneToOne(mappedBy = "employee")
	private EmpInfo empInfo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
