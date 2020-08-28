package com.dao;

import com.db.HibernateTemplate;
import com.dto.Customer;
import com.dto.Volunteer;

public class VolunteerDAO {

	public int register(Volunteer volunteer) {
		return HibernateTemplate.addObject(volunteer);
	}

	public Volunteer login(String loginId, String password) {
		return (Volunteer) HibernateTemplate.getVolunteerLogin(loginId, password);
	}

	public Volunteer getVolunteerById(int volunteerId) {
		return (Volunteer) HibernateTemplate.getVolunteer(volunteerId);
	}

	public void updateVolunteer(Volunteer volunteer) {
		int i =  HibernateTemplate.updateObject(volunteer);
		
	}

}
