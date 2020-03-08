package org.Info.Vehicle.dao;

import java.util.List;

import org.Info.Vehicle.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao{

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	public List<User> getAllUser() {
		Session session = this.sessionFactory.getCurrentSession();
		List<User>  UserList = session.createQuery("from User").list();
		return UserList;
	}

	public User getUser(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		User User = (User) session.get(User.class, id);
		return User;
	}

	public boolean checkUserExist(String username) {
		Session session = this.sessionFactory.getCurrentSession();
//		User user = (User) session.get(User.class, username);
		List<User>  userList = session.createQuery("FROM User u WHERE u.username = :user").setParameter("user", username).list();
		return !userList.isEmpty();
	    
	}
	

	public boolean checkUserValid(String username, String password) {
		Session session = this.sessionFactory.getCurrentSession();
//		User user = (User) session.get(User.class, username);
		List<User>  userList = session.createQuery("FROM User u WHERE u.username = :user AND  u.password = :password" ).setParameter("user", username).setParameter("password", password).list();
		return !userList.isEmpty();
	    
	}
	
	public User addUser(User User) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(User);
		return User;
	}

	public void updateUser(User User) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(User);
	}

	public void deleteUser(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		User p = (User) session.load(User.class, new Integer(id));
		if (null != p) {
			session.delete(p);
		}
	} 
}
