package com.dto;


import java.util.ArrayList;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "eventId")
@XmlRootElement
@Entity
public class Events {
	@Id@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int eventId;
	private String eventName;
	private Date doe;
	private String openTime;
	private String closeTime;
	private String info;
	
	@OneToMany(mappedBy="event")
	private List<Donation> donationList = new ArrayList<Donation>();
		
	@ManyToOne
	@JoinColumn(name="volunteerId")
	private Volunteer volunteer;
	
		
	public Events() {
		super();
	}


	
	public int getEventId() {
		return eventId;
	}


	public void setEventId(int eventId) {
		this.eventId = eventId;
	}


	public String getEventName() {
		return eventName;
	}


	public void setEventName(String eventName) {
		this.eventName = eventName;
	}


	public Date getDoe() {
		return doe;
	}


	public void setDoe(Date doe) {
		this.doe = doe;
	}


	public String getOpenTime() {
		return openTime;
	}


	public void setOpenTime(String openTime) {
		this.openTime = openTime;
	}


	public String getCloseTime() {
		return closeTime;
	}


	public void setCloseTime(String closeTime) {
		this.closeTime = closeTime;
	}


	public String getInfo() {
		return info;
	}


	public void setInfo(String info) {
		this.info = info;
	}


	public List<Donation> getDonationList() {
		return donationList;
	}


	public void setDonationList(List<Donation> donationList) {
		this.donationList = donationList;
	}


	public Volunteer getVolunteer() {
		return volunteer;
	}


	public void setVolunteer(Volunteer volunteer) {
		this.volunteer = volunteer;
	}

	
	}
