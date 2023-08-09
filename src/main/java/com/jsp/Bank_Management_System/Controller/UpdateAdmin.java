package com.jsp.Bank_Management_System.Controller;

import com.jsp.Bank_Management_System.Dto.AdminDto;
import com.jsp.Bank_Management_System.Service.AdminService;

public class UpdateAdmin {
	public static void main(String[] args) {
		
		AdminService adminService= new AdminService();
		AdminDto admin= adminService.updateAdminPasswordById(1,"Password");
		
		if(admin!=null)
		{
			System.out.println(admin.getName()+" updated succesfully");
		}else {
			System.out.println("no such record");
		}
	}
}
