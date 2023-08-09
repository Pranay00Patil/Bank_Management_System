package com.jsp.Bank_Management_System.Controller;

import javax.persistence.Query;

import com.jsp.Bank_Management_System.Dao.ManagerDao;
import com.jsp.Bank_Management_System.Dto.ManagerDto;
import com.jsp.Bank_Management_System.Service.ManagerService;

public class SaveManager {
	public static void main(String[] args) {
		ManagerDto managerDto= new ManagerDto();
		
		managerDto.setName("Vicky");
		managerDto.setGmail("pradeep@qwerty");
		managerDto.setPassword("12345678");
		managerDto.setStatus("approved");
		
		
		ManagerService managerService=new ManagerService();
		managerService.saveManager(managerDto);
		
	}
}
