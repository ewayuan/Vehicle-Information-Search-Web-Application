package org.Info.Vehicle.controller;

import java.util.List;

import org.Info.Vehicle.model.User;
import org.Info.Vehicle.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/getAllUser", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<User> getAllUser(Model model) {
		List<User> listOfUsers = userService.getAllUser();
		model.addAttribute("user", new User());
		model.addAttribute("listOfUsers", listOfUsers);
		return listOfUsers;
	}


	@RequestMapping(value = "/getUser/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public void getUserById(@PathVariable int id) {
		userService.getUser(id);
	}

	@RequestMapping(value = "/addUser", method = {RequestMethod.POST,RequestMethod.GET}, headers = "Accept=application/json")
//	@PostMapping(path = "/addUser")
	@ResponseBody
	public User addUser(String usertype, @RequestParam(required=false) String username, @RequestParam(required=false) String password) {
		// usage: http://localhost:8080/addUser?usertype="aaaa"&username="a"&password="bb"
//		System.out.println("hello");
//		System.out.println("username:"+username);
//		System.out.println("password:"+password);
//		System.out.println("usertype:"+usertype);
		return userService.addUser(username, password, usertype);

	}

	@RequestMapping(value = "/addUser", method = RequestMethod.PUT, headers = "Accept=application/json")
	public User updateUser(@RequestBody User user) {
		return userService.updateUser(user); 

	}	

	@PostMapping(value = "/updateUsername/{uid}/{newUsername}")
	public void updateUsername(@PathVariable("uid") int uid, @PathVariable("newUsername") String newUsername)  {
		userService.updateUsername(uid, newUsername); 

	}
	
	@PostMapping(value = "/updatePassword/{uid}/{newPassword}")
    public void updatePassword(@PathVariable("uid") int uid, @PathVariable("newPassword") String newPassword) { 
		userService.updatePassword(uid, newPassword); 
	}	
	
	@RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void deleteUser(@PathVariable("id") int id) {
		userService.deleteUser(id);
	}	
	
	@RequestMapping(value = "/checkUsernameExist/{username}", method = RequestMethod.GET, headers = "Accept=application/json")
	@ResponseBody
	public Boolean getUserByUsername(@PathVariable String username) {
		System.out.println(userService.checkUserExist(username));
	    return userService.checkUserExist(username);
	}
	
	@RequestMapping(value = "/checkUserValid/{username}/{password}", method = RequestMethod.GET, headers = "Accept=application/json")
	@ResponseBody
	public int checkUserValid(@PathVariable String username, @PathVariable String password) {
	    return userService.checkUserValid(username, password);
	}

}
