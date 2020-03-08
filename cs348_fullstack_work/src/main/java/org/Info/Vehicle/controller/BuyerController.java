package org.Info.Vehicle.controller;

import java.util.List;

import org.Info.Vehicle.model.Buyer;
import org.Info.Vehicle.service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BuyerController {

	@Autowired
	BuyerService buyerService;

	@RequestMapping(value = "/getAllBuyer", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Buyer> getAllBuyer(Model model) {
		List<Buyer> listOfBuyer = buyerService.getAllBuyer();
		model.addAttribute("buyer", new Buyer());
		model.addAttribute("listOfBuyer", listOfBuyer);
		return listOfBuyer;
	}



	@RequestMapping(value = "/getBuyer/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public void getBuyerById(@PathVariable int id) {
		buyerService.getBuyer(id);
	}

	@RequestMapping(value = "/addBuyer", method = RequestMethod.POST, headers = "Accept=application/json")
	public Buyer addBuyer(@RequestBody Buyer buyer) {
		return buyerService.addBuyer(buyer);

	}

	@RequestMapping(value = "/addBuyer", method = RequestMethod.PUT, headers = "Accept=application/json")
	public Buyer updateBuyer(@RequestBody Buyer buyer) {
		return buyerService.updateBuyer(buyer); 

	}	

	@RequestMapping(value = "/deleteBuyer/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void deleteBuyer(@PathVariable("id") int id) {
		buyerService.deleteBuyer(id);
	}	
}
