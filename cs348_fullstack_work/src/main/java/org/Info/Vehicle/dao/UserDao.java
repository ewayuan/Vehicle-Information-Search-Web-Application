package org.Info.Vehicle.dao;

import java.util.List;

import org.Info.Vehicle.model.User;

public interface UserDao {
	public List<User> getAllUser() ;

	public User getUser(int id) ;
	
	public boolean checkUserExist(String username);
	
	public boolean checkUserValid(String username, String password);

	public User addUser(User user);

	public void updateUser(User user) ;

	public void deleteUser(int id) ;
}
