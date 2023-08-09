package com.jsp.Bank_Management_System.Controller;

import com.jsp.Bank_Management_System.Service.ManagerService;

public class ApproveCustomers {
	public static void main(String[] args) {
		ManagerService managerService= new ManagerService();
		managerService.approvedCustomers(2);
	}
}
