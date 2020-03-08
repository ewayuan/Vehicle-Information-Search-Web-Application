package org.Info.Vehicle.dao;

import java.util.List;

import org.Info.Vehicle.model.Make;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MakeDaoImpl implements MakeDao{

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	public List<Make> getAllMake() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Make>  MakeList = session.createQuery("from Make").list();
		return MakeList;
	}

	public Make getMake(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Make Make = (Make) session.get(Make.class, id);
		return Make;
	}

	public Make addMake(Make Make) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(Make);
		return Make;
	}

	public void updateMake(Make Make) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(Make);
	}

	public void deleteMake(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Make p = (Make) session.load(Make.class, new Integer(id));
		if (null != p) {
			session.delete(p);
		}
	} 
}
