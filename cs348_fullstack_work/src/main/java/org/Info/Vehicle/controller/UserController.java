package org.Info.Vehicle.controller;

import java.util.List;

import org.Info.Vehicle.model.User;
import org.Info.Vehicle.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

	@RequestMapping(value = "/addUser", method = RequestMethod.POST, headers = "Accept=application/json")
	public User addUser(@RequestBody User user) {
		return userService.addUser(user);

	}

	@RequestMapping(value = "/addUser", method = RequestMethod.PUT, headers = "Accept=application/json")
	public User updateUser(@RequestBody User user) {
		return userService.updateUser(user); 

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
	public Boolean checkUserValid(@PathVariable String username, @PathVariable String password) {
	    return userService.checkUserValid(username, password);
	}

}
