package com.trail.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.trail.Entities.Patient;
import com.trail.Service.PatientService;

@RestController
public class PatientController {

	@Autowired
	private PatientService service;
	
	@GetMapping("/patients")
	public ResponseEntity<List<Patient>> getPatient() {
		List<Patient> patient = service.getAll();
	   if(patient.size()<=0) {
		   return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	   }
	   return ResponseEntity.of(Optional.of(patient));
	}
	
	//without status change
	/*
	 * @GetMapping("/patients/{id}") public Patient getByid(@PathVariable("id") int
	 * id) { Patient patient = service.getById(id); return patient; }
	 */
	
	@GetMapping("/patients/{id}")
	public ResponseEntity<Patient> getByid(@PathVariable("id") int id) {
		Patient patient = service.getById(id);
		if(patient==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(patient));
	}
	
	
	 @PostMapping("/patients")
	 public ResponseEntity<Patient>addPatient(@RequestBody Patient p) {
		 try { 
			 service.addPatient(p);
			 return ResponseEntity.status(HttpStatus.CREATED).build();
			 } 
		 catch (Exception e) {
	 e.printStackTrace();
	 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	 } 
		 }
	 
	
	@DeleteMapping("/patients/{id}")
	public ResponseEntity<Void> deletePatients(@PathVariable("id") int id) {
		try {
		service.deletePatient(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	catch(Exception e)
		{
		e.printStackTrace();
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	}
	@PutMapping("/patients/{id}")
	public void updatePatient(@RequestBody Patient p,@PathVariable("id") int id) 
	{
		//same here
	   service.update(id, p);
		
	}
}
