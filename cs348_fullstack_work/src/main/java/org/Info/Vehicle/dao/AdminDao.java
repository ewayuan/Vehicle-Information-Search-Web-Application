package org.Info.Vehicle.dao;

import java.util.List;

import org.Info.Vehicle.model.Admin;

public interface AdminDao {
	public List<Admin> getAllAdmin() ;

	public Admin getAdmin(int id) ;

	public Admin addAdmin(Admin admin);

	public void updateAdmin(Admin admin) ;

	public void deleteAdmin(int id) ;
}
