package org.Info.Vehicle.dao;

import java.util.List;

import org.Info.Vehicle.model.Cart;

public interface CartDao {
	public List<Cart> getAllCart() ;

	public Cart getCart(int id) ;

	public Cart addCart(Cart cart);

	public void updateCart(Cart cart) ;

	public void deleteCart(int id) ;
}
