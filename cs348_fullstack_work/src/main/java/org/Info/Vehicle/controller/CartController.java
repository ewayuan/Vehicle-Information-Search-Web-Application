package org.Info.Vehicle.controller;

import java.util.List;

import org.Info.Vehicle.model.Cart;
import org.Info.Vehicle.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartController {

	@Autowired
	CartService CartService;

	@RequestMapping(value = "/getAllCart", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Cart> getAllCart(Model model) {
		List<Cart> listOfCart = CartService.getAllCart();
		model.addAttribute("Cart", new Cart());
		model.addAttribute("listOfCart", listOfCart);
		return listOfCart;
	}

	@RequestMapping(value = "/getCart/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public void getCartById(@PathVariable int id) {
		CartService.getCart(id);
	}

	@RequestMapping(value = "/addCart", method = RequestMethod.POST, headers = "Accept=application/json")
	public Cart addCart(@RequestBody Cart Cart) {
		return CartService.addCart(Cart);

	}

	@RequestMapping(value = "/addCart", method = RequestMethod.PUT, headers = "Accept=application/json")
	public Cart updateCart(@RequestBody Cart Cart) {
		return CartService.updateCart(Cart); 

	}	

	@RequestMapping(value = "/deleteCart/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void deleteCart(@PathVariable("id") int id) {
		CartService.deleteCart(id);
	}	
}
