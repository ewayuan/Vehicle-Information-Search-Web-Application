
package org.Info.Vehicle.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="VehicleInfo")
public class VehicleInfo{

	@Id
	@Column(name="vid")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int vid;

	@Column(name="Year")
	String year; 

	@Column(name="mid")
	int mid; 

	@Column(name="Model")
	String model;
	
	@Column(name="Comb_Cons")
	float comb_cons;
	

	
	public VehicleInfo(int vid, String year, int mid, String model, float comb_cons) {
		super();
	}
	public VehicleInfo() {
		super();
		this.vid = vid; 
		this.year = year; 
		this.mid = mid; 
		this.model = model; 
		this.comb_cons = comb_cons;
	}
	public int getVid() {
		return this.vid;
	}
	
	public String getYear() {
		return this.year;
	}

	public int getMid() {
		return this.mid;
	}

	public String getModel() {
		return this.model;
	}

	public float getComb_cons() {
		return this.comb_cons;
	}

 	public void setVid(int vid) {
		this.vid = vid;
	}
	
	public void setYear(String year) {
		this.year = year;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setComb_cons(float comb_cons) {
		this.comb_cons = comb_cons;
	}
	
}
