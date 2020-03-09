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
	MakeService makeService;

	@RequestMapping(value = "/getAllMake", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Make> getAllMake(Model model) {
		List<Make> listOfMake = makeService.getAllMake();
		model.addAttribute("make", new Make());
		model.addAttribute("listOfMake", listOfMake);
		return listOfMake;
	}

	@RequestMapping(value = "/getMake/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String getMakeById(@PathVariable int id) {
		return makeService.getMake(id);
	}
	
	@RequestMapping(value = "/getmid/{makename}", method = RequestMethod.GET, headers = "Accept=application/json")
	public int getMid(@PathVariable String makename) {
		return makeService.getMid(makename);
	}

	@RequestMapping(value = "/addMake", method = RequestMethod.POST, headers = "Accept=application/json")
	public Make addMake(@RequestBody Make manufactuter) {
		return makeService.addMake(manufactuter);

	}

	@RequestMapping(value = "/addMake", method = RequestMethod.PUT, headers = "Accept=application/json")
	public Make updateMake(@RequestBody Make manufactuter) {
		return makeService.updateMake(manufactuter); 

	}	

	@RequestMapping(value = "/deleteMake/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void deleteMake(@PathVariable("id") int id) {
		makeService.deleteMake(id);
	}	
}
