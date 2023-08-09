package com.jsp.Bank_Management_System.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.Bank_Management_System.Dto.BankAccountDto;

public class BankAccountDao {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("nilesh");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	
//	
//	BankAccountDto bankAccountDto= new BankAccountDto();
//	
//	// Save bank detail
	public BankAccountDto saveBankDetail(BankAccountDto bankAccountDto) {
		bankAccountDto.setBalance(10000);
		entityTransaction.begin();
		entityManager.persist(bankAccountDto);
		entityTransaction.commit();
		return bankAccountDto;
	}
//	
//	
	// update bank detail
	public BankAccountDto updateBankName(int id,String name) {
		BankAccountDto bankAccountDto=entityManager.find(BankAccountDto.class,id);
		bankAccountDto.setBname(name);
		entityTransaction.begin();
		entityManager.merge(bankAccountDto);
		entityTransaction.commit();
		
		return bankAccountDto;
	}
	
	
//	BankAccountDto bankAccountDto=entityManager.find(BankAccountDto.class,bankid);
//	if(bankAccountDto!=null && bankAccountDto.getBalance()==1000) {
//		
//		System.out.println("=================================");
//		System.out.println(bankAccountDto.getId());
//		System.out.println(bankAccountDto.getBname());
//		System.out.println(bankAccountDto.getAccno());
//		System.out.println(bankAccountDto.getBalance());
////		System.out.println(bankAccountDto.get);
//	}
	public List<BankAccountDto> getBankDetail_Customers(){
		String sql="Select b from BankAccountDto b";
		Query query=entityManager.createQuery(sql);
		List<BankAccountDto> b=query.getResultList();
		
	
		return b;
	}
}
