
package org.Info.Vehicle.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * This is our model class and it corresponds to Cart table in database
 */
@Entity
@Table(name="Cart")
public class Cart{

	@Id
	@Column(name="cid")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int cid; 

	@Column(name="vid")
	int vid; 

	public Cart() {
		super();
	}

	public Cart(int cid, int vid) {
		super();
		this.cid=cid;
		this.vid=vid;
	}
	
	public int getCid() {
		return this.cid;
	}
	
	public void setUid(int cid) {
		this.cid = cid;
	}

	public int getVid() {
		return this.vid;
	}
	
	public void setVid(int vid) {
		this.vid = vid;
	}
	
}
