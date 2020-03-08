package org.Info.Vehicle.service;

import java.util.List;

import javax.transaction.Transactional;

import org.Info.Vehicle.dao.MakeDao;
import org.Info.Vehicle.model.Make;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("makeService")
public class MakeService {

	@Autowired
	MakeDao makeDao;

	@Transactional
	public List<Make> getAllMake() {
		return makeDao.getAllMake();
	}

	@Transactional
	public Make getMake(int id) {
		return makeDao.getMake(id);
	}

	@Transactional
	public Make addMake(Make make) {
		makeDao.addMake(make);
		return make;
	}

	@Transactional
	public Make updateMake(Make make) {
		makeDao.updateMake(make);
		return make;
	}

	@Transactional
	public void deleteMake(int id) {
		makeDao.deleteMake(id);
	}
}
