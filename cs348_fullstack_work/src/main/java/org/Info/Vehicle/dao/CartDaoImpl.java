package org.Info.Vehicle.dao;

import java.util.List;

import org.Info.Vehicle.model.Cart;
import org.Info.Vehicle.model.User;
import org.Info.Vehicle.model.VehicleInfo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

@Repository
public class CartDaoImpl implements CartDao{

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	public List<Cart> getAllCart() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Cart>  CartList = session.createQuery("from Cart").list();
		return CartList;
	}

	public Cart getCart(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Cart Cart = (Cart) session.get(Cart.class, id);
		return Cart;
	}

	public Cart addCart(Cart Cart) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(Cart);
		return Cart;
	}

	public void updateCart(Cart Cart) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(Cart);
	}

	public void deleteCart(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Cart p = (Cart) session.load(Cart.class, new Integer(id));
		if (null != p) {
			session.delete(p);
		}
	} 
	
	public void insertVid(int vid, int cid) {
	    Session session = this.sessionFactory.getCurrentSession();
	    session.beginTransaction();
		String searchSQLquery = "insert into Cart values(" +cid+", "+vid+")";
		session.createSQLQuery(searchSQLquery).executeUpdate();
	}
	
	public void deleteVid(int vid, int cid) {
	    Session session = this.sessionFactory.getCurrentSession();
	    session.beginTransaction();
		String searchSQLquery = "delete from Cart where vid = " +vid+" and cid = " + cid;
		session.createSQLQuery(searchSQLquery).executeUpdate();
	}
	
	public void uidAddCids(List<Integer> vidlist, int cid) {
		Session session = this.sessionFactory.getCurrentSession();
		for (int i = 0; i < vidlist.size(); i++) {
			insertVid(vidlist.get(i), cid);
		}
	}
	
	public void uidDelCids(List<Integer> vidlist, int cid) {
		Session session = this.sessionFactory.getCurrentSession();
		for (int i = 0; i < vidlist.size(); i++) {
			deleteVid(vidlist.get(i), cid);
		}
	}




}
