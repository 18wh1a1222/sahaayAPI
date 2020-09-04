package com.rest.Sahaay;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dao.CustomerDAO;
import com.dao.EventDAO;
import com.dao.NeedsDAO;
import com.dao.VolunteerDAO;
import com.dto.Customer;
import com.dto.Events;
import com.dto.Needs;
import com.dto.Volunteer;

@Path("myresource")
public class MyResource {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getIt() {
		return "Got it!";
	}

	@Path("regCustomer")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public void registerCustomer(Customer customer) {
		System.out.println("Cust"+ customer);
		CustomerDAO custdao = new CustomerDAO();
		custdao.register(customer);
	}
	
	@Path("regVolunteer")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public void registerVolunteer(Volunteer volunteer) {
		System.out.println("Cust"+ volunteer);
		VolunteerDAO voldao = new VolunteerDAO();
		voldao.register(volunteer);
	}

	
	@Path("regNeed")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public void registerNeed(Needs need) {
		System.out.println("Need"+ need );
		NeedsDAO needdao = new NeedsDAO();
		needdao.register(need);
	}
	
	@Path("regEvent")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public void registerEvent(Events event) {
		System.out.println("Need"+ event );
		EventDAO eventdao = new EventDAO();
		eventdao.register(event);
	}

	
	@Path("loginCustomer/{loginId}/{password}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Customer loginCustomer(@PathParam ("loginId") String loginId, @PathParam ("password") String password) {
		System.out.println(loginId);
		CustomerDAO custdao = new CustomerDAO();
		Customer cust = custdao.login(loginId, password);
		return cust;
	}
	
	@Path("loginVolunteer/{loginId}/{password}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Volunteer loginVolunteer(@PathParam ("loginId") String loginId, @PathParam ("password") String password) {
		System.out.println(loginId);
		VolunteerDAO voldao = new VolunteerDAO();
		Volunteer vol = voldao.login(loginId, password);
		return vol;
		
	}
	
	@Path("getAllNeeds")
	@GET
	@Produces(MediaType.APPLICATION_JSON) 
	public List<Needs> getAllNeeds() {
		NeedsDAO needdao = new NeedsDAO();
		List<Needs> needList = needdao.getAllNeeds();
		return needList;
		
	}
	
	@Path("getMyNeeds/{customerId}")
	@GET
	@Produces(MediaType.APPLICATION_JSON) 
	public List<Needs> getMyNeeds(@PathParam ("customerId") int customerId) {
		NeedsDAO needdao = new NeedsDAO();
		List<Needs> needList = needdao.getMyNeeds(customerId);
		return needList;
		
	}
	
	@Path("getAllEvents")
	@GET
	@Produces(MediaType.APPLICATION_JSON) 
	public List<Events> getAllEvents() {
		EventDAO eventdao = new EventDAO();
		List<Events> eventList = eventdao.getAllEvents();
		return eventList;
		
	}
	
	@Path("getCustomer/{customerId}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Customer getCustomer(@PathParam ("customerId") int customerId) {
		CustomerDAO custdao = new CustomerDAO();
		Customer cust = custdao.getCustomerById(customerId);
		return cust;
	}
	
	@Path("getVolunteer/{volunteerId}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Volunteer getVolunteer(@PathParam ("volunteerId") int volunteerId) {
		VolunteerDAO voldao = new VolunteerDAO();
		Volunteer vol = voldao.getVolunteerById(volunteerId);
		return vol;
	}
	
	@Path("updateVolunteer")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateVolunteer(Volunteer volunteer){
		System.out.println("Data Recieved in update : " + volunteer); 
		VolunteerDAO voldao = new VolunteerDAO();
		voldao.updateVolunteer(volunteer);
		
	}
}
