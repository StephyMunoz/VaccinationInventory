package com.vaccination;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.vaccination.model.Employee;
import com.vaccination.repository.IAdminRepo;

@SpringBootTest
class VaccinationInventoryApplicationTests {

	@Autowired
	private IAdminRepo repo;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Test
	public void createUser() {
		Employee emp = new Employee();
		emp.setId(3);
		emp.setName("Renata");
		emp.setLastname("Cevallos");
		emp.setEmail("rena@ff.com");

		Employee response = repo.save(emp);

		assert (response.getEmail().equalsIgnoreCase(emp.getEmail()));
	}

}
