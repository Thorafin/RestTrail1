package com.trail.Dao;

import org.springframework.data.repository.CrudRepository;

import com.trail.Entities.Patient;

public interface PatientDao extends CrudRepository<Patient, Integer> {

	public Patient getById(int id);
	
}
