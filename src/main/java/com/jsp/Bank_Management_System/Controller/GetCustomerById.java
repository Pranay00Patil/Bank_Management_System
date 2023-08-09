package com.jsp.Bank_Management_System.Controller;

import com.jsp.Bank_Management_System.Dto.CustomersDto;
import com.jsp.Bank_Management_System.Service.CustomerService;

public class GetCustomerById {
	public static void main(String[] args) {
		CustomerService customerService = new CustomerService();
		CustomersDto customers=customerService.getCustomersById(1);
		if(customers!=null) {
			System.out.println("=================================");
			System.out.println(customers.getId());
			System.out.println(customers.getName());
			System.out.println(customers.getGender());
			System.out.println(customers.getDob());
			System.out.println(customers.getBankaccount());
		}
	}
}
