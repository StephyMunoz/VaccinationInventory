package com.vaccination.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vaccination.model.EmpInfo;
import com.vaccination.repository.IEmpInfoRepo;

@Service
public class EmpInformationService {

	@Autowired
	private IEmpInfoRepo repo;

	public EmpInfo getById(int id) {
		return repo.getById(id);
	}
}
