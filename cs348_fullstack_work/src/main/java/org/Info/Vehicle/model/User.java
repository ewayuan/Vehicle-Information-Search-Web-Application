
package org.Info.Vehicle.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * This is our model class and it corresponds to User table in database
 */
@Entity
@Table(name="User")
public class User{

	@Id
	@Column(name="uid")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int uid;

	@Column(name="username")
	String username; 

	@Column(name="password")
	String password;
	
	@Column(name="user_type")
	String usertype;

	public User() {
		super();
	}

	public User(int uid, String username,String password, String usertype) {
		super();
		this.uid = uid;
		this.username = username;
		this.password=password;
		this.usertype = usertype;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	
	public String getUsertype() {
		return usertype;
	}
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	
	
}
