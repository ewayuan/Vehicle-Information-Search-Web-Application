package org.Info.Vehicle.service;

import java.util.List;

import javax.transaction.Transactional;

import org.Info.Vehicle.dao.BuyerDao;
import org.Info.Vehicle.model.Buyer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("buyerService")
public class BuyerService {

	@Autowired
	BuyerDao BuyerDao;

	@Transactional
	public List<Buyer> getAllBuyer() {
		return BuyerDao.getAllBuyer();
	}

	@Transactional
	public Buyer getBuyer(int id) {
		return BuyerDao.getBuyer(id);
	}

	@Transactional
	public Buyer addBuyer(Buyer buyer) {
		BuyerDao.addBuyer(buyer);
		return buyer;
	}

	@Transactional
	public Buyer updateBuyer(Buyer buyer) {
		BuyerDao.updateBuyer(buyer);
		return buyer;
	}

	@Transactional
	public void deleteBuyer(int id) {
		BuyerDao.deleteBuyer(id);
	}
}
