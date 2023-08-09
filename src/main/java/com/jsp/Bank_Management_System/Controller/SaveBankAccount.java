package com.jsp.Bank_Management_System.Controller;

import com.jsp.Bank_Management_System.Dao.CustomerDao;
import com.jsp.Bank_Management_System.Dto.BankAccountDto;
import com.jsp.Bank_Management_System.Service.CustomerService;

public class SaveBankAccount {
	public static void main(String[] args) {
		
		BankAccountDto bankAccountDto= new BankAccountDto();
		bankAccountDto.setBname("hdfc");
		bankAccountDto.setAccno(492249210491l);
		bankAccountDto.setIfsc("kkbk40544");
		bankAccountDto.setBalance(500);
	
		CustomerService customerService=new CustomerService();
		customerService.saveBankDetail(1,bankAccountDto);
		
		
		
	}
}


