package org.Info.Vehicle.dao;

import java.util.List;

import org.Info.Vehicle.model.Buyer;
import org.Info.Vehicle.model.Make;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BuyerDaoImpl implements BuyerDao{

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	public List<Buyer> getAllBuyer() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Buyer>  BuyerList = session.createQuery("from Buyer").list();
		return BuyerList;
	}

	public Buyer getBuyer(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Buyer Buyer = (Buyer) session.get(Buyer.class, id);
		return Buyer;
	}

	public Buyer addBuyer(Buyer Buyer) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(Buyer);
		return Buyer;
	}

	public void updateBuyer(Buyer Buyer) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(Buyer);
	}

	public void deleteBuyer(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Buyer p = (Buyer) session.load(Buyer.class, new Integer(id));
		if (null != p) {
			session.delete(p);
		}
	} 
	
	public int getCid(int uid) {
		Session session = this.sessionFactory.getCurrentSession();
		String searchQ = "from Buyer WHERE uid = " + uid;
		List<Buyer> bList = session.createQuery(searchQ).list();
		Buyer b;
		try {
			b = bList.get(0);
		} catch(Exception e) {
			b = null;
		}
		return b.getCid();
	}
}
