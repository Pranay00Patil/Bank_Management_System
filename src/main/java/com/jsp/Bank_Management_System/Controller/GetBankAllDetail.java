package com.jsp.Bank_Management_System.Controller;

import java.util.List;

import com.jsp.Bank_Management_System.Dao.BankAccountDao;
import com.jsp.Bank_Management_System.Dto.BankAccountDto;
import com.jsp.Bank_Management_System.Dto.CustomersDto;

public class GetBankAllDetail {
	public static void main(String[] args) {
		BankAccountDao bankAccountDao = new BankAccountDao();
		CustomersDto customersDto = new CustomersDto();
		List<BankAccountDto> b = bankAccountDao.getBankDetail_Customers();
		for (BankAccountDto bankAccountDto : b) {
			if (bankAccountDto.getCustomers().getName().equals("Bunty")) {
				System.out.println("=================================");
				System.out.println(bankAccountDto.getId());
				System.out.print(bankAccountDto.getBname() + " ");
			System.out.println(" customers name :-"+bankAccountDto.getCustomers().getName());
				System.out.println(bankAccountDto.getAccno());
				System.out.println(bankAccountDto.getBalance());
				System.out.println("customers manager name :-" + bankAccountDto.getCustomers().getManagerDto().getName());
				System.out.println("customers admin name :-" + bankAccountDto.getCustomers().getManagerDto().getAdmin().getName());
			}else {
				System.out.println("no customers name bunty");
			}
		}
	}
}
