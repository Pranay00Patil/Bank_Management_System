package com.jsp.Bank_Management_System.Service;

import java.util.List;

import com.jsp.Bank_Management_System.Dao.CustomerDao;
import com.jsp.Bank_Management_System.Dto.BankAccountDto;
import com.jsp.Bank_Management_System.Dto.CustomersDto;

public class CustomerService {
	CustomerDao customerDao=new CustomerDao();
	
	// save customers
		public CustomersDto saveCustomers(CustomersDto customersDto) {
			return customerDao.saveCustomers(customersDto);
		}
		
		
	// delete customers
	public CustomersDto deleteCustomersById(int id) {
		return customerDao.deleteCustomersById(id);
	}
	
	
	// update customers name by id
		public CustomersDto updateCustomersNameById(int id,String name) {
			return customerDao.updateCustomersNameById(id,name);
		}
		
		
	// update customers dob by id
	public CustomersDto updateCustomersDobById(int id,String dob) {
		return customerDao.updateCustomersDobById(id,dob);
	}
	
	

	// update customers gender by id
	public CustomersDto updateCustomersGenderById(int id,String gender) {
		return customerDao.updateCustomersGenderById(id,gender);
	}
	
	// get customers by Id
	public CustomersDto getCustomersById(int id) {
		return customerDao.getCustomersById(id);
	}
	
	//Get all customers 
		public List<CustomersDto> getAllCustomers(){
			return customerDao.getAllCustomers();
		}
	// save bank detail
		public BankAccountDto saveBankDetail(int id,BankAccountDto bankAccountDto) {
			return customerDao.saveBankDetail(id,bankAccountDto);
		}
		
	// update bank detail
		public BankAccountDto updateBankName(int id,String name) {
			return customerDao.updateBankName(id, name);
		}
		
	// deposite money
	public BankAccountDto depositeMoney(int customersId, int bankId, double ammount) {
		return customerDao.depositeMoney(customersId,bankId, ammount);
	}
	
	// transfer money
	public BankAccountDto transferMoney(int customerId,int sender,int receiver,double ammountTranfer) {
		return customerDao.transferMoney(customerId,sender, receiver, ammountTranfer);
	}
}
