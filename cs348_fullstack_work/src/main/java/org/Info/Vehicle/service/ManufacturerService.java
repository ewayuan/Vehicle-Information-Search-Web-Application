package org.Info.Vehicle.service;

import java.util.List;

import javax.transaction.Transactional;

import org.Info.Vehicle.dao.ManufacturerDao;
import org.Info.Vehicle.model.Manufacturer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("manufacturerService")
public class ManufacturerService {

	@Autowired
	ManufacturerDao manufacturerDao;

	@Transactional
	public List<Manufacturer> getAllManufacturer() {
		return manufacturerDao.getAllManufacturer();
	}

	@Transactional
	public Manufacturer getManufacturer(int id) {
		return manufacturerDao.getManufacturer(id);
	}

	@Transactional
	public Manufacturer addManufacturer(Manufacturer manufacturer) {
		manufacturerDao.addManufacturer(manufacturer);
		return manufacturer;
	}

	@Transactional
	public Manufacturer updateManufacturer(Manufacturer manufacturer) {
		manufacturerDao.updateManufacturer(manufacturer);
		return manufacturer;
	}

	@Transactional
	public void deleteManufacturer(int id) {
		manufacturerDao.deleteManufacturer(id);
	}
}
