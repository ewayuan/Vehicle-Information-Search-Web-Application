
package org.Info.Vehicle.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * This is our model class and it corresponds to Produce table in database
 */
@Entity
@Table(name="Produce")
public class Produce{

	@Id
	@Column(name="pid")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int pid; 

	@Column(name="vid")
	int vid; 

	public Produce() {
		super();
	}

	public Produce(int pid, int vid) {
		super();
		this.pid=pid;
		this.vid=vid;
	}
	
	public int getPid() {
		return this.pid;
	}
	
	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getVid() {
		return this.vid;
	}
	
	public void setUid(int vid) {
		this.vid = vid;
	}
	
}
