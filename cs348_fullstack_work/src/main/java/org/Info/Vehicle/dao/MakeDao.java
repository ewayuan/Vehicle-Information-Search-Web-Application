package org.Info.Vehicle.dao;

import java.util.List;

import org.Info.Vehicle.model.Make;

public interface MakeDao {
	public List<Make> getAllMake() ;

	public Make getMake(int id) ;

	public Make addMake(Make make);

	public void updateMake(Make make) ;

	public void deleteMake(int id) ;
}
