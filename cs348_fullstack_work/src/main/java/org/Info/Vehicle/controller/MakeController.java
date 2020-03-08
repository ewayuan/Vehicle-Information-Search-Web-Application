package org.Info.Vehicle.controller;

import java.util.List;

import org.Info.Vehicle.model.Make;
import org.Info.Vehicle.service.MakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MakeController {

	@Autowired
	MakeService manufactuterService;

	@RequestMapping(value = "/getAllMake", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Make> getAllMake(Model model) {
		List<Make> listOfMake = manufactuterService.getAllMake();
		model.addAttribute("make", new Make());
		model.addAttribute("listOfMake", listOfMake);
		return listOfMake;
	}

	@RequestMapping(value = "/getMake/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public void getMakeById(@PathVariable int id) {
		manufactuterService.getMake(id);
	}

	@RequestMapping(value = "/addMake", method = RequestMethod.POST, headers = "Accept=application/json")
	public Make addMake(@RequestBody Make manufactuter) {
		return manufactuterService.addMake(manufactuter);

	}

	@RequestMapping(value = "/addMake", method = RequestMethod.PUT, headers = "Accept=application/json")
	public Make updateMake(@RequestBody Make manufactuter) {
		return manufactuterService.updateMake(manufactuter); 

	}	

	@RequestMapping(value = "/deleteMake/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void deleteMake(@PathVariable("id") int id) {
		manufactuterService.deleteMake(id);
	}	
}
