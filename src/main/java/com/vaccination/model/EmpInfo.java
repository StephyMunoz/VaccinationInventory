package com.vaccination.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "emp_information")
public class EmpInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotNull(message = "El campo fecha de nacimiento debe ser llenado")
	@Column
	@Past
	private Date dateOfBirth;

	@NotEmpty(message = "El campo dirección debe ser llenado")
	@Column
	private String address;

	@NotEmpty(message = "El campo número telefónico debe ser llenado")
	@Column
	@Pattern (regexp = "^(\\d{10})$", message = "El número telefónico debe contener 10 números")
	private String phonenumber;

	@NotNull(message = "El campo debe ser llenado")
	@Column
	private boolean vaccinated;

	@OneToOne
	@JoinColumn(name = "employee_id")
	private Employee employee;

	@Column(nullable = true, length = 40)
	private String vaccine;

	@Column(nullable = true)
	@Past
	private Date vaccinationDate;

	@Column(nullable = true, length = 1)
	private int doses;

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public boolean isVaccinated() {
		return vaccinated;
	}

	public void setVaccinated(boolean vaccinated) {
		this.vaccinated = vaccinated;
	}

	public String getVaccine() {
		return vaccine;
	}

	public void setVaccine(String vaccine) {
		this.vaccine = vaccine;
	}

	public Date getVaccinationDate() {
		return vaccinationDate;
	}

	public void setVaccinationDate(Date vaccinationDate) {
		this.vaccinationDate = vaccinationDate;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public int getDoses() {
		return doses;
	}

	public void setDoses(int doses) {
		this.doses = doses;
	}

}
