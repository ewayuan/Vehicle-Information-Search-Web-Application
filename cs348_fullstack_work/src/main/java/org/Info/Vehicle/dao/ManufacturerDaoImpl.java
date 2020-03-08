package org.Info.Vehicle.dao;

import java.util.List;

import org.Info.Vehicle.model.Manufacturer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ManufacturerDaoImpl implements ManufacturerDao{

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	public List<Manufacturer> getAllManufacturer() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Manufacturer>  ManufacturerList = session.createQuery("from Manufacturer").list();
		return ManufacturerList;
	}

	public Manufacturer getManufacturer(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Manufacturer Manufacturer = (Manufacturer) session.get(Manufacturer.class, id);
		return Manufacturer;
	}

	public Manufacturer addManufacturer(Manufacturer Manufacturer) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(Manufacturer);
		return Manufacturer;
	}

	public void updateManufacturer(Manufacturer Manufacturer) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(Manufacturer);
	}

	public void deleteManufacturer(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Manufacturer p = (Manufacturer) session.load(Manufacturer.class, new Integer(id));
		if (null != p) {
			session.delete(p);
		}
	} 
}
