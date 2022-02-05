package com.trail.Service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.trail.Dao.PatientDao;
import com.trail.Entities.Patient;

@Component
public class PatientService {

	@Autowired
	private PatientDao dao;
	
	
	/*
	 * static List<Patient> patients = new ArrayList(); static { 
	 * patients.add(new Patient(1000,"Mohan","12/08/2000","Chennai"));
	 * patients.add(new Patient(1002,"Sohan","12/01/2000","madras"));
	 * patients.add(new Patient(1003,"Rohan","01/08/2000","nagpur"));
	 * patients.add(new Patient(1004,"logan","12/08/2021","delhi")); }
	 */
	 
	
	public List<Patient> getAll(){
		List<Patient> patients =(List<Patient>) dao.findAll();
		return patients;
	}
	/*
	 * public Patient getById(int id) { Patient pat =null; try { pat =
	 * patients.stream().filter(p->p.getId()==id).findFirst().get(); }
	 * catch(Exception e) { e.printStackTrace(); } return pat; }
	 */
	
	public Patient getById(int id) {
	Patient patient = dao.getById(id);
    return patient;		
		
	}
	
	
	public Patient addPatient(Patient p) {
		Patient patient = dao.save(p);
		return patient;
	}
	
	public void deletePatient(int id) {
		  Patient patient = dao.getById(id);
		  dao.delete(patient);
	}
	
	public void update(int id,Patient pat) {
     Patient patient = dao.getById(id);	
     patient.setAddress(pat.getAddress());
     patient.setDate(pat.getDate());
     patient.setName(pat.getName());
}
}