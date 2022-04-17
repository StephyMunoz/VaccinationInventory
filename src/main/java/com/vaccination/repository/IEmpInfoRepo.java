package com.vaccination.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vaccination.model.EmpInfo;

public interface IEmpInfoRepo extends JpaRepository<EmpInfo, Integer> {
}