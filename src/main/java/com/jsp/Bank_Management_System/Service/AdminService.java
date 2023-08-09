package com.jsp.Bank_Management_System.Service;

import java.util.List;

import com.jsp.Bank_Management_System.Dao.AdminDao;
import com.jsp.Bank_Management_System.Dto.AdminDto;
import com.jsp.Bank_Management_System.Dto.ManagerDto;

public class AdminService {

	AdminDao adminDao=new AdminDao();
	
	//saveSerice
	public AdminDto saveAdmin(AdminDto admin)
	{
		AdminDto admin2=adminDao.saveAdmin(admin);
		return admin2;
	}
	
	
	// delete services
	public   AdminDto deletetAdminById(int id)
	{
		 
		return  adminDao.deletetAdminById( id);
	}
	
	
//	update name by id
	public  AdminDto updateAdminNameById(int id,String name) {
		return adminDao.updateAdminNameById(id, name);
	}
	
	
	//Update gmail by id
	public  AdminDto updateAdminGmailById(int id,String gmail) {
		return adminDao.updateAdminGmailById(id, gmail);
	}
	
	
	//Update password by id
	public  AdminDto updateAdminPasswordById(int id,String password) {
		return adminDao.updateAdminPasswordById(id, password);
	}
	
	
	// Get Admin by Id
	public AdminDto getAdminById(int id) {
		return adminDao.getAdminById(id);
	}
	
	
	// get All Admiin
	public  List<AdminDto> getAllAdmin(
			)
	{
		return adminDao.getAllAdmin();
	}
	
	public List<ManagerDto> approvedManager(int id)
	{
//		AdminDao adminDao=new AdminDao();
		
		return adminDao.approvedManager(id);
	}
}
