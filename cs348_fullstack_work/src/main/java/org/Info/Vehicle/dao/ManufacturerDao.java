package org.Info.Vehicle.dao;

import java.util.List;

import org.Info.Vehicle.model.Manufacturer;

public interface ManufacturerDao {
		public List<Manufacturer> getAllManufacturer();

		public Manufacturer getManufacturer(int id) ;

		public Manufacturer addManufacturer(Manufacturer manufactuter);

		public void updateManufacturer(Manufacturer manufactuter) ;

		public void deleteManufacturer(int uid) ;
}
