
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

	@Column(name="Year")
	String year; 

	@Column(name="mid")
	int mid; 

	@Column(name="model")
	String model;
	
	@Column(name="VehicleClass")
	String VehicleClass;
	
	@Column(name="EngineSize")
    float EngineSize;
	
	@Column(name="Cylinders")
	int Cylinders;
	
	@Column(name="FuelType")
    String FuelType;
	
	@Column(name="City")
    float City;
	
	@Column(name="Hwy")
    float Hwy;
		
	@Column(name="Comb")
	float Comb;

	@Column(name="CO2Rating")
    int CO2Rating;
	
	@Column(name="SmogRating")
	int SmogRating;		

	@Id
	@Column(name="vid")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int vid;

	//@Coulumn(name="imgUrl")
	//String imgUrl;

	@Column(name="make_name")
	String make_name;
	
	public VehicleInfo(int vid, String year, int mid, String model, float Comb) {
		super();
	}
	public VehicleInfo() {
		super();
		this.vid = vid; 
		this.year = year; 
		this.mid = mid; 
		this.model = model; 
		this.Comb = Comb;
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
		return this.Comb;
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

	public void setComb_cons(float Comb) {
		this.Comb = Comb;
	}
	
}
