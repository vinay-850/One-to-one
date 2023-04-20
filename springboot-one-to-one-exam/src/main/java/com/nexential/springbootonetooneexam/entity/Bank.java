package com.nexential.springbootonetooneexam.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Bank")
public class Bank 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String Bank_Name;
	private String phoneNo;
	public Bank() {
		super();
	}
	public Bank(Long id, String bank_Name, String phoneNo) {
		super();
		this.id = id;
		Bank_Name = bank_Name;
		this.phoneNo = phoneNo;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getBank_Name() {
		return Bank_Name;
	}
	public void setBank_Name(String bank_Name) {
		Bank_Name = bank_Name;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	@Override
	public String toString() {
		return "Bank [id=" + id + ", Bank_Name=" + Bank_Name + ", phoneNo=" + phoneNo + "]";
	}
	
	
}
