package com.jsp.Bank_Management_System.Controller;

import com.jsp.Bank_Management_System.Service.AdminService;

public class DeleteAdmin {
	public static void main(String[] args) {
		AdminService adminService= new AdminService();
		adminService.deletetAdminById(2);
	}
}
