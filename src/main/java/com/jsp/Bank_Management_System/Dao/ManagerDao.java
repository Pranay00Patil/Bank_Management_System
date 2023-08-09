package com.jsp.Bank_Management_System.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.Bank_Management_System.Dto.CustomersDto;
import com.jsp.Bank_Management_System.Dto.ManagerDto;

public class ManagerDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("nilesh");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	// Save Manager
	public ManagerDto saveManager(ManagerDto manager) {
		manager.setStatus("unapproved");
		entityTransaction.begin();
		entityManager.persist(manager);
		entityTransaction.commit();
		return manager;
	}

	// delete Manager
	public ManagerDto deleteManagerById(int id) {
		ManagerDto manager = entityManager.find(ManagerDto.class, id);
		entityTransaction.begin();
		entityManager.remove(manager);
		entityTransaction.commit();
		return manager;
	}

	// Update Manager name by id
	public ManagerDto updateManagerNameById(int id, String name) {
		ManagerDto manager = entityManager.find(ManagerDto.class, id);
		manager.setName(name);
		entityTransaction.begin();
		entityManager.merge(manager);
		entityTransaction.commit();
		return manager;
	}

	// Update Manager gmail by id
	public ManagerDto updateManagerGmailById(int id, String gmail) {
		ManagerDto manager = entityManager.find(ManagerDto.class, id);
		manager.setGmail(gmail);
		entityTransaction.begin();
		entityManager.merge(manager);
		entityTransaction.commit();
		return manager;
	}

	// Update Manager password by id
	public ManagerDto updateManagerPasswordById(int id, String password) {
		ManagerDto manager = entityManager.find(ManagerDto.class, id);
		manager.setPassword(password);
		entityTransaction.begin();
		entityManager.merge(manager);
		entityTransaction.commit();
		return manager;
	}

	// get Manager ID
	public ManagerDto getManagerById(int id) {
		ManagerDto manager = entityManager.find(ManagerDto.class, id);
		return manager;
	}

	// get All MAnager
	public List<ManagerDto> getAllManager() {
		String sql = "Select m from ManagerDto m";

		Query query = entityManager.createQuery(sql);

		List<ManagerDto> m = query.getResultList();

//		for (ManagerDto managerDto : m) {
//			System.out.println("=============================");
//			System.out.println(managerDto.getId());
//			System.out.println(managerDto.getName());
//			System.out.println(managerDto.getGmail());
//			System.out.println(managerDto.getPassword());
//			System.out.println(managerDto.getStatus());
//		}
		return m;
	}

	// approved customers
	public List<CustomersDto> approvedCustomers(int id) {
		ManagerDto manager = entityManager.find(ManagerDto.class, id);
		List<CustomersDto> customers = null;
		if (manager != null) 
		{
			if (manager.getStatus().equals("approved")) 
			{
				String sql = "select c from CustomersDto c";
				Query query = entityManager.createQuery(sql);

				customers = query.getResultList();
				for (CustomersDto c : customers) 
				{
					if (c.getStatus().equals("Unapproved")) {
						c.setStatus("approved");
						c.setManagerDto(manager);
						entityTransaction.begin();
						entityManager.merge(c);
						entityTransaction.commit();
						System.out.println("customer approved");
					}
				}
			}else {
				System.out.println("you are not approved manager");
			}
		} else {
			System.out.println("Manager " + id + " does not exist");
		}
		return customers;
	}

}
