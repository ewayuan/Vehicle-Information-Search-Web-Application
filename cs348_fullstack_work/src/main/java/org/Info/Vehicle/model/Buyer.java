
package org.Info.Vehicle.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * This is our model class and it corresponds to Buyer table in database
 */
@Entity
@Table(name="Buyer")
public class Buyer{

	@Id
	@Column(name="uid")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int uid;

	@Column(name="cid")
	int cid; 

	public Buyer() {
		super();
	}

	public Buyer(int uid, int cid) {
		super();
		this.uid=uid;
		this.cid=cid;
	}
	
	public int getUid() {
		return this.uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	
}
