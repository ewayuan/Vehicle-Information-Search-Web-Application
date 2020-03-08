package org.Info.Vehicle.controller;

import java.util.List;

import org.Info.Vehicle.model.VehicleInfo;
import org.Info.Vehicle.service.VehicleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VehicleInfoController {

	@Autowired
	VehicleInfoService vehicleInfoService;

	@RequestMapping(value = "/getAllVehicleInfo", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<VehicleInfo> getAllVehicleInfo(Model model) {
		List<VehicleInfo> listOfVehicleInfo = vehicleInfoService.getAllVehicleInfo();
		model.addAttribute("VehicleInfo", new VehicleInfo());
		model.addAttribute("listOfVehicleInfo", listOfVehicleInfo);
		return listOfVehicleInfo;
	}

	@RequestMapping(value = "/getVehicleInfo/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public void getVehicleInfobyID(@PathVariable int id) {
		vehicleInfoService.getVehicleInfo(id);
	}
	
	@RequestMapping(value = "/addVehicleInfo", method = RequestMethod.POST, headers = "Accept=application/json")
	public VehicleInfo addVehicleInfo(@RequestBody VehicleInfo vehicleInfo) {
		return vehicleInfoService.addVehicleInfo(vehicleInfo);

	}

	@RequestMapping(value = "/addVehicleInfo", method = RequestMethod.PUT, headers = "Accept=application/json")
	public VehicleInfo updateVehicleInfo(@RequestBody VehicleInfo vehicleInfo) {
		return vehicleInfoService.updateVehicleInfo(vehicleInfo); 
	}	

	@RequestMapping(value = "/deleteVehicleInfo/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void deleteVehicleInfo(@PathVariable("id") int id) {
		vehicleInfoService.deleteVehicleInfo(id);
	}
	
	@RequestMapping(value = "/allUniqueModels", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<String> getAllUniqueModels() {
		return vehicleInfoService.getAllUniqueModels();
	}	
	
	@RequestMapping(value = "/allUniqueYears", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Integer> getAllUniqueYears() {
		return vehicleInfoService.getAllUniqueYears();
	}	
	
	@RequestMapping(value = "/allUniqueConsumptions", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Float> getAllUniqueConsumptions() {
		return vehicleInfoService.getAllUniqueConsumptions();
	}	
}
