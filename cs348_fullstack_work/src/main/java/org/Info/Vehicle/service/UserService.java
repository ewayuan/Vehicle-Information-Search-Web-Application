package org.Info.Vehicle.service;

import java.util.List;

import javax.transaction.Transactional;

import org.Info.Vehicle.dao.UserDao;
import org.Info.Vehicle.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("userService")
public class UserService {

	@Autowired
	UserDao userDao;

	@Transactional
	public List<User> getAllUser() {
		return userDao.getAllUser();
	}

	@Transactional
	public User getUser(int id) {
		return userDao.getUser(id);
	}

	@Transactional
	public boolean checkUserExist(String username) {
		return userDao.checkUserExist(username);
	}
	
	@Transactional
	public int checkUserValid(String username, String password) {
		return userDao.checkUserValid(username, password);
	}
	
	@Transactional
	public User addUser(String username, String password, String usertype) {
		return userDao.addUser(username, password, usertype);
	}

	@Transactional
	public User updateUser(User user) {
		userDao.updateUser(user);
		return user;
	}

	@Transactional
	public void deleteUser(int id) {
		userDao.deleteUser(id);
	}

	@Transactional
	public void updateUsername(int uid, String newUsername) {
		userDao.updateUsername(uid, newUsername);
	}

	@Transactional
	public void updatePassword(int uid, String newPassword) {
		userDao.updatePassword(uid, newPassword);
	}
}
