package com.jsp.Bank_Management_System.Dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Customers")
public class CustomersDto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int id;
	private String name;
	private String gender;
	private String dob;
	private String status;
	
	@OneToMany(mappedBy = "customers")
	private List<BankAccountDto> bankaccount;
	
	
	@ManyToOne
	@JoinColumn
	private ManagerDto managerDto;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public List<BankAccountDto> getBankaccount() {
		return bankaccount;
	}

	public void setBankaccount(List<BankAccountDto> bankaccount) {
		this.bankaccount = bankaccount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ManagerDto getManagerDto() {
		return managerDto;
	}

	public void setManagerDto(ManagerDto managerDto) {
		this.managerDto = managerDto;
	}

	
	
	
	

}
