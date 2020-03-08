package org.Info.Vehicle.dao;

import java.util.List;

import org.Info.Vehicle.model.Buyer;

public interface BuyerDao {
	public List<Buyer> getAllBuyer() ;

	public Buyer getBuyer(int id) ;

	public Buyer addBuyer(Buyer customer);

	public void updateBuyer(Buyer customer) ;

	public void deleteBuyer(int id) ;
}
