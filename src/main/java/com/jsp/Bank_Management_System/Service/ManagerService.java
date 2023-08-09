package com.jsp.Bank_Management_System.Service;

import java.util.List;

import com.jsp.Bank_Management_System.Dao.ManagerDao;
import com.jsp.Bank_Management_System.Dto.CustomersDto;
import com.jsp.Bank_Management_System.Dto.ManagerDto;

public class ManagerService {
	ManagerDao managerDao=new ManagerDao();
	
	// Save manager
	public ManagerDto saveManager(ManagerDto manager)
	{
		ManagerDto manager2=managerDao.saveManager(manager);
		return manager2;
	}
	
	// Delete Manager
	public ManagerDto deleteManagerById(int id)
	{
		ManagerDto manager=managerDao.deleteManagerById(id);
		
		return manager;
	}
	
	// Update Manager name by id
	public ManagerDto updateManagerNameById(int id,String name) {
			return managerDao.updateManagerNameById(id,name);
		}
		
	// Update Manager gmail by id
	public ManagerDto updateManagerGmailById(int id,String gmail) {
		return managerDao.updateManagerGmailById(id,gmail);		 
		}		

	// Update Manager gmail by id
	public ManagerDto updateManagerPasswordById(int id,String gmail) {
		return managerDao.updateManagerPasswordById(id,gmail);		 
		}
	//get Manager ID
		public ManagerDto getManagerById(int id) {
			ManagerDto manager=managerDao.getManagerById(id);
			return manager;
		}
		
	// get All MAnager
		public List<ManagerDto> getAllManager() {
			List<ManagerDto> ml=managerDao.getAllManager();
			
			return ml;
		}
	// approved customers
		public List<CustomersDto> approvedCustomers(int id){
			return managerDao.approvedCustomers(id);
		}
}
