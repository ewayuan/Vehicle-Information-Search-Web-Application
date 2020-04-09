package org.Info.Vehicle.dao;

import java.util.List;

import org.Info.Vehicle.model.User;

public interface UserDao {
	public List<User> getAllUser() ;

	public User getUser(int id) ;
	
	public boolean checkUserExist(String username);
	
	public boolean checkUserValid(String username, String password);

	public User addUser(String username, String password, String usertype);

	public void updateUser(User user) ;

	public void deleteUser(int id) ;

	public void updateUsername(int uid, String newUsername);

	public void updatePassword(int uid, String newPassword);
	
	
}
