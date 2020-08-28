package com.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "volunteerId")
@JsonIgnoreProperties(allowSetters = true, value = { "transList", "eventList", "donarList" })
@XmlRootElement
@Entity
public class Volunteer {
	@Id@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int volunteerId;
	private String volunteerName;
	private int age;
	private String gender;
	private String phone;
	private String loginId;
	private String password;
	private String ngoName;
	private Double covidAssess;
	private String isDonor;
	private String isVolunteer;
	
	@OneToMany(mappedBy="volunteer")
	private List<Events> eventList = new ArrayList<Events>();
	
	@OneToMany(mappedBy="volunteer")
	private List<Transaction> transList = new ArrayList<Transaction>();
	
	@OneToMany(mappedBy="volunteer")
	private List<Donation> donarList = new ArrayList<Donation>();
	
	public Volunteer() {}

	

	public int getVolunteerId() {
		return volunteerId;
	}

	public void setVolunteerId(int volunteerId) {
		this.volunteerId = volunteerId;
	}

	public String getVolunteerName() {
		return volunteerName;
	}

	public void setVolunteerName(String volunteerName) {
		this.volunteerName = volunteerName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNgoName() {
		return ngoName;
	}

	public void setNgoName(String ngoName) {
		this.ngoName = ngoName;
	}

	public Double getCovidAssess() {
		return covidAssess;
	}

	public void setCovidAssess(Double covidAssess) {
		this.covidAssess = covidAssess;
	}

	public String getIsDonor() {
		return isDonor;
	}

	public void setIsDonor(String isDonor) {
		this.isDonor = isDonor;
	}

	public String getIsVolunteer() {
		return isVolunteer;
	}

	public void setIsVolunteer(String isVolunteer) {
		this.isVolunteer = isVolunteer;
	}

	public List<Events> getEventList() {
		return eventList;
	}

	public void setEventList(List<Events> eventList) {
		this.eventList = eventList;
	}

	public List<Transaction> getTransList() {
		return transList;
	}

	public void setTransList(List<Transaction> transList) {
		this.transList = transList;
	}

	public List<Donation> getDonarList() {
		return donarList;
	}

	public void setDonarList(List<Donation> donarList) {
		this.donarList = donarList;
	}

	
		
}
