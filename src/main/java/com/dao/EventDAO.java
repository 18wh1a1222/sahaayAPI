package com.dao;

import java.util.List;

import com.db.HibernateTemplate;
import com.dto.Events;
import com.dto.Needs;

public class EventDAO {

	public int register(Events event) {
		java.util.Date utilDate = new java.sql.Date(event.getDoe().getTime()); 
		return HibernateTemplate.addObject(event);
		
	}

	public List<Events> getAllEvents() {
		List<Events> eventList = (List)HibernateTemplate.getObjectListByQuery("From Events");
		return eventList;
	}
}
