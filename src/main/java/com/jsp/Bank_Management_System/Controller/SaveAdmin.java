package com.jsp.Bank_Management_System.Controller;

import java.util.ArrayList;
import java.util.List;

import com.jsp.Bank_Management_System.Dto.AdminDto;
import com.jsp.Bank_Management_System.Dto.ManagerDto;
import com.jsp.Bank_Management_System.Service.AdminService;
import com.jsp.Bank_Management_System.Service.ManagerService;

public class SaveAdmin {
	public static void main(String[] args) {
		AdminDto adminDto=new AdminDto();
		adminDto.setName("Nilesh");
		adminDto.setGmail("ry@gami.com");
		adminDto.setPassword("qwert@123");
		
		AdminDto adminDto1=new AdminDto();
		adminDto1.setName("Pranay");
		adminDto1.setGmail("sy@gami.com");
		adminDto1.setPassword("qwert@123");
		System.out.println("done..");
		
		
		
		AdminService adminService= new AdminService();
		adminService.saveAdmin(adminDto);
		adminService.saveAdmin(adminDto1);
		
		
		
		
		
		
		


		
	}
}
