package com.jsp.Bank_Management_System.Controller;

import java.util.List;

import com.jsp.Bank_Management_System.Dto.AdminDto;
import com.jsp.Bank_Management_System.Service.AdminService;

public class AllAdminDetail {
	public static void main(String[] args) {
		AdminService adminService= new AdminService();
		List<AdminDto> a=adminService.getAllAdmin();
		for(AdminDto ad:a )
			{
				System.out.println("===========================================================");
				System.out.print(ad.getId()+" \t ");
				System.out.print(ad.getName()+" \t ");
				System.out.print(ad.getGmail()+" \t ");
				System.out.print(ad.getPassword()+" \t ");
				System.out.println();
			}
	}
}
