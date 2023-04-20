package com.nexential.springbootonetooneexam.entity;

import com.nexential.springbootonetooneexam.request.Request;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="people")
public class People 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String dateofbirth;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="bank_id")
	private Bank bank;
	
	public People(Request req)
	{
		this.name=req.getName();
		this.dateofbirth=req.getDateofbirth();
	}
	
	public People() {
		super();
	}
	
	public People(Long id, String name, String dateofbirth, Bank bank) {
		super();
		this.id = id;
		this.name = name;
		this.dateofbirth = dateofbirth;
		this.bank = bank;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(String dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	@Override
	public String toString() {
		return "People [id=" + id + ", name=" + name + ", dateofbirth=" + dateofbirth + ", bank=" + bank + "]";
	}
	
	
	
}
