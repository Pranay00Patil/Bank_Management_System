package com.jsp.Bank_Management_System.Controller;

import com.jsp.Bank_Management_System.Dto.BankAccountDto;
import com.jsp.Bank_Management_System.Service.CustomerService;

public class TranferMoney {
	public static void main(String[] args) {
		CustomerService customerService=new CustomerService();
		BankAccountDto bankAccountDto=customerService.transferMoney(1,2, 1, 500);
		if(bankAccountDto!=null) {
			System.out.println("transaction Complete");
		}else {
			System.out.println("transaction failed");
		}
	}
}
