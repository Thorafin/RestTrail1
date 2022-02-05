package com.trail.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trail.Dao.AppointmentDao;
import com.trail.Entities.Appointment;
import com.trail.Entities.Patient;

@Service
public class AppointmentService {

	@Autowired
	private AppointmentDao dao;
	
	public List<Appointment> getAll(){
		List<Appointment> appointments =(List<Appointment>) dao.findAll();
		return appointments;
	} 
	
	public Appointment getById(int id) {
		Appointment appointment = dao.getById(id);
	    return appointment;		
		}
	
	public Appointment addAppointment(Appointment ap) {
		Appointment appoint = dao.save(ap);
		return appoint;
	}
	
	public void deleteAppointment(int id) {
		Appointment appointment  = dao.getById(id);
		  dao.delete(appointment);
	}
	
	
	
	
	
	
}
