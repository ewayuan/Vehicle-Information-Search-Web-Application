package org.Info.Vehicle.controller;

import java.util.List;

import org.Info.Vehicle.model.Admin;
import org.Info.Vehicle.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

	@Autowired
	AdminService adminService;

	@RequestMapping(value = "/getAllAdmin", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Admin> getAllAdmin(Model model) {
		List<Admin> listOfAdmin = adminService.getAllAdmin();
		model.addAttribute("admin", new Admin());
		model.addAttribute("listOfAdmin", listOfAdmin);
		return listOfAdmin;
	}

	@RequestMapping(value = "/getAdmin/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public void getAdminById(@PathVariable int id) {
		adminService.getAdmin(id);
	}

	@RequestMapping(value = "/addAdmin", method = RequestMethod.POST, headers = "Accept=application/json")
	public Admin addAdmin(@RequestBody Admin admin) {
		return adminService.addAdmin(admin);

	}

	@RequestMapping(value = "/addAdmin", method = RequestMethod.PUT, headers = "Accept=application/json")
	public Admin updateAdmin(@RequestBody Admin admin) {
		return adminService.updateAdmin(admin); 

	}	

	@RequestMapping(value = "/deleteAdmin/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void deleteAdmin(@PathVariable("id") int id) {
		adminService.deleteAdmin(id);
	}	
}
