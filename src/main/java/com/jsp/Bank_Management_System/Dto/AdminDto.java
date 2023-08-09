package com.jsp.Bank_Management_System.Dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Admin")
public class AdminDto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	private String Name;
	private String gmail;
	private String password;
	
	
	@OneToMany(mappedBy = "admin")
	private List<ManagerDto> manager;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGmail() {
		return gmail;
	}

	public void setGmail(String gmail) {
		this.gmail = gmail;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public List<ManagerDto> getManager() {
		return manager;
	}


	public void setManager(List<ManagerDto> manager) {
		this.manager = manager;
	}

}
