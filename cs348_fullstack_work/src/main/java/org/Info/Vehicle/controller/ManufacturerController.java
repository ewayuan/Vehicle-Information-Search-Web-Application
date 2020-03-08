package org.Info.Vehicle.controller;

import java.util.List;

import org.Info.Vehicle.model.Manufacturer;
import org.Info.Vehicle.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ManufacturerController {

	@Autowired
	ManufacturerService manufacturerService;

	@RequestMapping(value = "/getAllManufacturer", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Manufacturer> getAllManufacturer(Model model) {
		List<Manufacturer> listOfManufacturer = manufacturerService.getAllManufacturer();
		model.addAttribute("manufacturer", new Manufacturer());
		model.addAttribute("listOfManufacturer", listOfManufacturer);
		return listOfManufacturer;
	}

	@RequestMapping(value = "/getManufacturer/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public void getManufacturerById(@PathVariable int id) {
		manufacturerService.getManufacturer(id);
	}

	@RequestMapping(value = "/addManufacturer", method = RequestMethod.POST, headers = "Accept=application/json")
	public Manufacturer addManufacturer(@RequestBody Manufacturer manufacturer) {
		return manufacturerService.addManufacturer(manufacturer);

	}

	@RequestMapping(value = "/addManufacturer", method = RequestMethod.PUT, headers = "Accept=application/json")
	public Manufacturer updateManufacturer(@RequestBody Manufacturer manufacturer) {
		return manufacturerService.updateManufacturer(manufacturer); 

	}	

	@RequestMapping(value = "/deleteManufacturer/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void deleteManufacturer(@PathVariable("id") int id) {
		manufacturerService.deleteManufacturer(id);
	}	
}
