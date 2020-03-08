package org.Info.Vehicle.dao;

import java.util.List;

import org.Info.Vehicle.model.Admin;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdminDaoImpl implements AdminDao{

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	public List<Admin> getAllAdmin() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Admin>  AdminList = session.createQuery("from Admin").list();
		return AdminList;
	}

	public Admin getAdmin(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Admin Admin = (Admin) session.get(Admin.class, id);
		return Admin;
	}

	public Admin addAdmin(Admin Admin) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(Admin);
		return Admin;
	}

	public void updateAdmin(Admin Admin) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(Admin);
	}

	public void deleteAdmin(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Admin p = (Admin) session.load(Admin.class, new Integer(id));
		if (null != p) {
			session.delete(p);
		}
	} 
}
