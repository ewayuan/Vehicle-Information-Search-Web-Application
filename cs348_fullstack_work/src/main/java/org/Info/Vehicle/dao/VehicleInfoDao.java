package org.Info.Vehicle.dao;

import java.util.List;

import org.Info.Vehicle.model.VehicleInfo;

public interface VehicleInfoDao {
	public List<VehicleInfo> getAllVehicleInfo() ;

	public VehicleInfo getVehicleInfo(int id) ;

	public VehicleInfo addVehicleInfo(VehicleInfo vehicleInfo);

	public void updateVehicleInfo(VehicleInfo vehicleInfo) ;

	public void deleteVehicleInfo(int cid) ;

	public List<String> getAllUniqueModels();

	public List<Integer> getAllUniqueYears();

	public List<Float> getAllUniqueConsumptions();
}
