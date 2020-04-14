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
	

	public int checkUserValid(String username, String password) {
		Session session = this.sessionFactory.getCurrentSession();
//		User user = (User) session.get(User.class, username);
		List<User>  userList = session.createQuery("FROM User u WHERE u.username = :user AND  u.password = :password" ).setParameter("user", username).setParameter("password", password).list();
		if (userList.isEmpty()) {
			return -1;
		} 
		return userList.get(0).getUid();
	    
	}
	
	public User addUser(String username, String password, String usertype) {
		Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();
//		System.out.println("hello");
//		System.out.println("username:"+username);
//		System.out.println("password:"+password);
//		System.out.println("usertype:"+usertype);
	    //Add new Employee object
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setUsertype(usertype);
//	    System.out.println("print username: "  +user.getUsername());
//	    System.out.println("print password: "  +user.getPassword());
//	    System.out.println("print usertype: "  +user.getUsertype());
	         
	    session.save(user);
//	    session.getTransaction().commit();
		return user;
	    
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

	
	public void updateUsername(int uid, String newUsername) {
		Session session = this.sessionFactory.getCurrentSession();
		User currentUser = getUser(uid);
		currentUser.setUsername(newUsername);
	    session.save(currentUser);
	}

	
	public void updatePassword(int uid, String newPassword) {
		Session session = this.sessionFactory.getCurrentSession();
		User currentUser = getUser(uid);
		currentUser.setPassword(newPassword);
//		currentUser.password = newPassword;
	    session.save(currentUser);
	} 
	
}
