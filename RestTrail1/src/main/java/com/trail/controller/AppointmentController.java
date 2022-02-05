package com.trail.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.trail.Entities.Appointment;
import com.trail.Entities.Patient;
import com.trail.Service.AppointmentService;

@Controller
public class AppointmentController {

	@Autowired
	private AppointmentService service;
	
	
	@GetMapping("/appointments")
	public ResponseEntity<List<Appointment>> getAll(){
		List<Appointment> appointments = service.getAll();
	  if(appointments.size()<=0) {
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();  
	  }
	  return  ResponseEntity.of(Optional.of(appointments));
	}
	
	@GetMapping("/appointments/{id}")
	public ResponseEntity<Appointment> getAppointmentById(@PathVariable("id") int id)
	{
		Appointment appointment = service.getById(id);
		if(appointment==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(appointment));
	}
	
	@PostMapping("/appointments")
	 public ResponseEntity<Appointment>addAppointment(@RequestBody Appointment ap) {
		 try { 
			 service.addAppointment(ap);
			 return ResponseEntity.status(HttpStatus.CREATED).build();
			 } 
		 catch (Exception e) {
	 e.printStackTrace();
	 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	     } 
		 } 
	
	@DeleteMapping("/appointments/{id}")
	public ResponseEntity<Void> deleteAppointment(@PathVariable("id") int id){
		service.deleteAppointment(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
}
