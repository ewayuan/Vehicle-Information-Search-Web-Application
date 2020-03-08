package org.Info.Vehicle.dao;

import java.util.List;

import org.Info.Vehicle.model.Produce;

public interface ProduceDao {
	public List<Produce> getAllProduce() ;

	public Produce getProduce(int id) ;

	public Produce addProduce(Produce produce);

	public void updateProduce(Produce produce) ;

	public void deleteProduce(int id) ;
}
