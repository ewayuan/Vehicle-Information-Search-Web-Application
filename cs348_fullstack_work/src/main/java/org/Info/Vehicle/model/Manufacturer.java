
package org.Info.Vehicle.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * This is our model class and it corresponds to Manufactuter table in database
 */
@Entity
@Table(name="Manufacturer")
public class Manufacturer{

	@Id
	@Column(name="uid")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int uid;

	@Column(name="pid")
	int pid; 

	public Manufacturer() {
		super();
	}

	public Manufacturer(int uid, int pid) {
		super();
		this.uid=uid;
		this.pid=pid;
	}
	
	public int getUid() {
		return this.uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	
}
