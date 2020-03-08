
package org.Info.Vehicle.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * This is our model class and it corresponds to Admin table in database
 */
@Entity
@Table(name="Admin")
public class Admin{

	@Id
	@Column(name="uid")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int uid; 

	public Admin() {
		super();
	}

	public Admin(int uid) {
		super();
		this.uid=uid;
	}
	
	public int getUid() {
		return this.uid;
	}
	
	public void setUid(int uid) {
		this.uid = uid;
	}
	
}
