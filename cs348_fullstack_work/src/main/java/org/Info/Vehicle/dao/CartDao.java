package org.Info.Vehicle.dao;

import java.util.List;

import org.Info.Vehicle.model.Cart;

public interface CartDao {
	public List<Cart> getAllCart() ;

	public Cart getCart(int id) ;

	public Cart addCart(Cart cart);

	public void updateCart(Cart cart) ;

	public void deleteCart(int id) ;

	public void insertVid(int vid, int cid);
	
	public void deleteVid(int vid, int cid);
	
	public void uidAddCids(List<Integer> vidlist, int cid);
	
	public void uidDelCids(List<Integer> vidlist, int cid);

}
