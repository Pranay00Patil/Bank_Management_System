package com.jsp.Bank_Management_System.Controller;

import com.jsp.Bank_Management_System.Dto.BankAccountDto;
import com.jsp.Bank_Management_System.Service.CustomerService;

public class DepositeMoney {
	public static void main(String[] args) {
		CustomerService customerService=new CustomerService();
		BankAccountDto bankAccountDto= customerService.depositeMoney(1,2, 1000);
		if(bankAccountDto!=null) {
			System.out.println("money deposited succesfully");
		}else {
			System.out.println("invalid bank id");
		}
	}
}
