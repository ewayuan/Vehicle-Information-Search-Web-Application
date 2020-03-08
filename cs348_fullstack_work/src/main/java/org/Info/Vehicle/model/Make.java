
package org.Info.Vehicle.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * This is our model class and it corresponds to Make table in database
 */
@Entity
@Table(name="Make")
public class Make{

	@Id
	@Column(name="mid")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int mid;

	@Column(name="make_name")
	String make_name; 

	public Make() {
		super();
	}

	public Make(int mid, String make_name) {
		super();
		this.mid=mid;
		this.make_name=make_name;
	}
	
	public String getMake() {
		return this.make_name;
	}
	public void setMake(String make_name) {
		this.make_name = make_name;
	}

	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	
}
