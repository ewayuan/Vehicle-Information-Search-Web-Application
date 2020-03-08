package org.Info.Vehicle.dao;

import java.util.List;

import org.Info.Vehicle.model.Produce;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProduceDaoImpl implements ProduceDao{

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	public List<Produce> getAllProduce() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Produce>  ProduceList = session.createQuery("from Produce").list();
		return ProduceList;
	}

	public Produce getProduce(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Produce Produce = (Produce) session.get(Produce.class, id);
		return Produce;
	}

	public Produce addProduce(Produce Produce) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(Produce);
		return Produce;
	}

	public void updateProduce(Produce Produce) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(Produce);
	}

	public void deleteProduce(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Produce p = (Produce) session.load(Produce.class, new Integer(id));
		if (null != p) {
			session.delete(p);
		}
	} 
}
