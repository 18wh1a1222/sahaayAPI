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
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "needId")
//@JsonIgnoreProperties(allowSetters = true, value = { "transList" })
@XmlRootElement
@Entity
public class Needs {
	@Id@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int needId;
	private String info;
	private Double money;
	private String status;
	private String type;
	private Date don;
	
	@OneToMany(mappedBy="needs")
	private List<Transaction> transList = new ArrayList<Transaction>();
	
	@ManyToOne
	@JoinColumn(name="customerId")
	private Customer customer;
	
	
	
	public Needs() {	}




	public int getNeedId() {
		return needId;
	}

	public void setNeedId(int needId) {
		this.needId = needId;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getDon() {
		return don;
	}

	public void setDon(Date don) {
		this.don = don;
	}

	public List<Transaction> getTransList() {
		return transList;
	}

	public void setTransList(List<Transaction> transList) {
		this.transList = transList;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	
}
