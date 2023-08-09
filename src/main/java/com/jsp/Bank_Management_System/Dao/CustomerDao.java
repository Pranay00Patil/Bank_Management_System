package com.jsp.Bank_Management_System.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.Bank_Management_System.Dto.BankAccountDto;
import com.jsp.Bank_Management_System.Dto.CustomersDto;

public class CustomerDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("nilesh");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	// save customers
	public CustomersDto saveCustomers(CustomersDto customersDto) {
		customersDto.setStatus("Unapproved");
		entityTransaction.begin();
		entityManager.persist(customersDto);
		entityTransaction.commit();
		return customersDto;
	}

	// delete customers
	public CustomersDto deleteCustomersById(int id) {
		CustomersDto customersDto = entityManager.find(CustomersDto.class, id);
		entityTransaction.begin();
		entityManager.remove(customersDto);
		entityTransaction.commit();
		return customersDto;
	}

	// update customers name by id
	public CustomersDto updateCustomersNameById(int id, String name) {
		CustomersDto customersDto = entityManager.find(CustomersDto.class, id);
		customersDto.setName(name);
		entityTransaction.begin();
		entityManager.merge(customersDto);
		entityTransaction.commit();
		return customersDto;
	}

	// update customers dob by id
	public CustomersDto updateCustomersDobById(int id, String dob) {
		CustomersDto customersDto = entityManager.find(CustomersDto.class, id);
		customersDto.setDob(dob);
		entityTransaction.begin();
		entityManager.merge(customersDto);
		entityTransaction.commit();
		return customersDto;
	}

	// update customers gender by id
	public CustomersDto updateCustomersGenderById(int id, String gender) {
		CustomersDto customersDto = entityManager.find(CustomersDto.class, id);
		customersDto.setGender(gender);
		entityTransaction.begin();
		entityManager.merge(customersDto);
		entityTransaction.commit();
		return customersDto;
	}

	// get customers by Id
	public CustomersDto getCustomersById(int id) {

		return entityManager.find(CustomersDto.class, id);
	}

	// Get all customers
	public List<CustomersDto> getAllCustomers() {

		String sql = "Select c from CustomersDto c";

		Query query = entityManager.createQuery(sql);
		List<CustomersDto> c = query.getResultList();

		for (CustomersDto customers : c) {
			System.out.println("=================================");
			System.out.println(customers.getId());
			System.out.println(customers.getName());
			System.out.println(customers.getGender());
			System.out.println(customers.getDob());
			System.out.println(customers.getBankaccount());
		}
		return c;
	}

	// Save bank Accoount
	public BankAccountDto saveBankDetail(int id, BankAccountDto bankAccountDto) {

		CustomersDto customersDto = entityManager.find(CustomersDto.class, id);
		if (customersDto != null) {
			if (customersDto.getStatus().equals("approved")) {

				bankAccountDto.setBalance(1000);
				bankAccountDto.setCustomers(customersDto);
				entityTransaction.begin();
				entityManager.persist(bankAccountDto);
				entityTransaction.commit();
			} else {
				System.out.println("You are not approved Customers");
			}
		} else {
			System.out.println("customers not found");
		}
		return bankAccountDto;
	}

	// update bank detail
	public BankAccountDto updateBankName(int id, String name) {
		BankAccountDto bankAccountDto = entityManager.find(BankAccountDto.class, id);
		bankAccountDto.setBname(name);
		entityTransaction.begin();
		entityManager.merge(bankAccountDto);
		entityTransaction.commit();

		return bankAccountDto;
	}

	// deposite money
	public BankAccountDto depositeMoney(int customersId, int bankId, double ammount) {
		CustomersDto customersDto = entityManager.find(CustomersDto.class, customersId);
		BankAccountDto bankAccountDto = bankAccountDto = entityManager.find(BankAccountDto.class, bankId);
		if (customersDto != null) {
			if (customersDto.getStatus().equals("approved")
					&& bankAccountDto.getCustomers().getId() == customersDto.getId()) {

				if (ammount > 0) {
					bankAccountDto.setBalance(bankAccountDto.getBalance() + ammount);

					entityTransaction.begin();
					entityManager.merge(bankAccountDto);
					entityTransaction.commit();
				}

			} else {
				System.out.println("Your are not Approved");
//				return null;
			}
		} else {
			System.out.println("Customers " + customersId + " not found");
			return null;
		}
		return bankAccountDto;
	}

	// Transfer money
	public BankAccountDto transferMoney(int customerId, int sender, int receiver, double ammountTranfer) {

		CustomersDto customersDto = entityManager.find(CustomersDto.class, customerId);
		BankAccountDto bankAccount1 = entityManager.find(BankAccountDto.class, sender);
		BankAccountDto bankAccount2 = entityManager.find(BankAccountDto.class, receiver);
		if (customersDto.getStatus().equals("approved") && bankAccount1.getCustomers().getId() == customerId) {

			if (bankAccount1 != null && bankAccount2 != null) {

				if (bankAccount1.getBalance() >= ammountTranfer && ammountTranfer > 0) {
					bankAccount1.setBalance(bankAccount1.getBalance() - ammountTranfer);
					bankAccount2.setBalance(bankAccount2.getBalance() + ammountTranfer);

					entityTransaction.begin();
					entityManager.merge(bankAccount1);
					entityManager.merge(bankAccount2);
					entityTransaction.commit();
				} else {
					System.out.println("insufficent bank balance");
					return null;
				}
			} else {
				System.out.println("no such account");
				return null;
			}
		}else {
			System.out.println("You are not approved Or ");
		}
		return bankAccount2;
	}

//	public CustomersDto transferMoney(int receiver,double amount) {
//		CustomersDto customersDto=customerDao.getCustomersById(receiver);
//		 first by using reciever id call the method of getbankby id and set balance = getbalance + amount;
	/*
	 * and then call once agai get method of customer have set its bank balancle
	 * getbalance- amount;
	 * 
	 */
//		
//	}

}
