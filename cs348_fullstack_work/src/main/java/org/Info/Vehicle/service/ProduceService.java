package org.Info.Vehicle.service;

import java.util.List;

import javax.transaction.Transactional;

import org.Info.Vehicle.dao.ProduceDao;
import org.Info.Vehicle.model.Produce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("produceService")
public class ProduceService {

	@Autowired
	ProduceDao produceDao;

	@Transactional
	public List<Produce> getAllProduce() {
		return produceDao.getAllProduce();
	}

	@Transactional
	public Produce getProduce(int id) {
		return produceDao.getProduce(id);
	}

	@Transactional
	public Produce addProduce(Produce produce) {
		produceDao.addProduce(produce);
		return produce;
	}

	@Transactional
	public Produce updateProduce(Produce produce) {
		produceDao.updateProduce(produce);
		return produce;
	}

	@Transactional
	public void deleteProduce(int id) {
		produceDao.deleteProduce(id);
	}
}
