package org.Info.Vehicle.service;

import java.util.List;

import javax.transaction.Transactional;

import org.Info.Vehicle.dao.AdminDao;
import org.Info.Vehicle.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("adminService")
public class AdminService {

	@Autowired
	AdminDao adminDao;

	@Transactional
	public List<Admin> getAllAdmin() {
		return adminDao.getAllAdmin();
	}

	@Transactional
	public Admin getAdmin(int id) {
		return adminDao.getAdmin(id);
	}

	@Transactional
	public Admin addAdmin(Admin admin) {
		adminDao.addAdmin(admin);
		return admin;
	}

	@Transactional
	public Admin updateAdmin(Admin admin) {
		adminDao.updateAdmin(admin);
		return admin;
	}

	@Transactional
	public void deleteAdmin(int id) {
		adminDao.deleteAdmin(id);
	}
}
