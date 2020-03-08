package org.Info.Vehicle.service;

import java.util.List;

import javax.transaction.Transactional;

import org.Info.Vehicle.dao.CartDao;
import org.Info.Vehicle.model.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("cartService")
public class CartService {

	@Autowired
	CartDao cartDao;

	@Transactional
	public List<Cart> getAllCart() {
		return cartDao.getAllCart();
	}

	@Transactional
	public Cart getCart(int id) {
		return cartDao.getCart(id);
	}

	@Transactional
	public Cart addCart(Cart cart) {
		cartDao.addCart(cart);
		return cart;
	}

	@Transactional
	public Cart updateCart(Cart cart) {
		cartDao.updateCart(cart);
		return cart;
	}

	@Transactional
	public void deleteCart(int id) {
		cartDao.deleteCart(id);
	}
}
