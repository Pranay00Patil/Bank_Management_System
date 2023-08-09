package com.jsp.Bank_Management_System.Controller;

import com.jsp.Bank_Management_System.Dto.CustomersDto;
import com.jsp.Bank_Management_System.Service.CustomerService;

public class SaveCustomer {
	public static void main(String[] args) {
		CustomersDto customersDto=new CustomersDto();
		customersDto.setName("Bubli");
		customersDto.setGender("male");
		customersDto.setDob("07-03-2000");
		customersDto.setStatus("approved");
		
		CustomerService customerService= new CustomerService();
		customerService.saveCustomers(customersDto);
	}
}
