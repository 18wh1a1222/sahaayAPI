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

//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "customerId")
@JsonIgnoreProperties(allowSetters = true, value = { "needsList" })
@XmlRootElement
@Entity
public class Customer {
	@Id@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int customerId;
	private String customerName;
	private int age;
	private String gender;
	private String loginId;
	private String password;
	private String longitude;
	private String latitude;
	private String govId;
	private Double covidAssess;
	private String phone;
	
	@OneToMany(mappedBy="customer")
	private List<Needs> needsList = new ArrayList<Needs>();
	
	@OneToMany(mappedBy="customer")
	private List<Transaction> transList = new ArrayList<Transaction>();
	
	

	public Customer() {}


	public int getCustomerId() {
		return customerId;
	}



	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}



	public String getCustomerName() {
		return customerName;
	}



	public void setCustomerName(String customerName) {
		this.customerName = customerName;
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



	public String getLongitude() {
		return longitude;
	}



	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}



	public String getLatitude() {
		return latitude;
	}



	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}



	public String getGovId() {
		return govId;
	}



	public void setGovId(String govId) {
		this.govId = govId;
	}



	public Double getCovidAssess() {
		return covidAssess;
	}



	public void setCovidAssess(Double covidAssess) {
		this.covidAssess = covidAssess;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public List<Needs> getNeedsList() {
		return needsList;
	}



	public void setNeedsList(List<Needs> needsList) {
		this.needsList = needsList;
	}



	public List<Transaction> getTransList() {
		return transList;
	}



	public void setTransList(List<Transaction> transList) {
		this.transList = transList;
	}
	
	

	
	
}
