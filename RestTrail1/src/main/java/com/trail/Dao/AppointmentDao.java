package com.trail.Dao;

import org.aspectj.weaver.tools.Trace;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.trail.Entities.Appointment;

public interface AppointmentDao extends CrudRepository<Appointment,Integer> {

	@Query(value="select * from appointment where aid=:n ",nativeQuery = true)
	public Appointment getById(@Param("n")int id);
	
	
	
	
	
}
