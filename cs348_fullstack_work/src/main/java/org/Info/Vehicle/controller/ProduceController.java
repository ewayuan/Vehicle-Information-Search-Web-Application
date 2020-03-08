package org.Info.Vehicle.controller;

import java.util.List;

import org.Info.Vehicle.model.Produce;
import org.Info.Vehicle.service.ProduceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProduceController {

	@Autowired
	ProduceService produceService;

	@RequestMapping(value = "/getAllProduce", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Produce> getAllProduce(Model model) {
		List<Produce> listOfProduce = produceService.getAllProduce();
		model.addAttribute("produce", new Produce());
		model.addAttribute("listOfProduce", listOfProduce);
		return listOfProduce;
	}

	@RequestMapping(value = "/getProduce/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public void getProduceById(@PathVariable int id) {
		produceService.getProduce(id);
	}

	@RequestMapping(value = "/addProduce", method = RequestMethod.POST, headers = "Accept=application/json")
	public Produce addProduce(@RequestBody Produce produce) {
		return produceService.addProduce(produce);

	}

	@RequestMapping(value = "/addProduce", method = RequestMethod.PUT, headers = "Accept=application/json")
	public Produce updateProduce(@RequestBody Produce produce) {
		return produceService.updateProduce(produce); 

	}	

	@RequestMapping(value = "/deleteProduce/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void deleteProduce(@PathVariable("id") int id) {
		produceService.deleteProduce(id);
	}	
}
