package org.Info.Vehicle.dao;

import java.util.List;

import org.Info.Vehicle.model.VehicleInfo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class VehicleInfoDaoImpl implements VehicleInfoDao{

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	public List<VehicleInfo> getAllVehicleInfo() {
		Session session = this.sessionFactory.getCurrentSession();
		List<VehicleInfo>  vehicleInfoList = session.createQuery("from VehicleInfo").list();
		return vehicleInfoList;
	}

	public VehicleInfo getVehicleInfo(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		VehicleInfo vehicleInfo = (VehicleInfo) session.get(VehicleInfo.class, id);
		return vehicleInfo;
	}

	public VehicleInfo addVehicleInfo(VehicleInfo vehicleInfo) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(vehicleInfo);
		return vehicleInfo;
	}

	public void updateVehicleInfo(VehicleInfo vehicleInfo) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(vehicleInfo);
	}

	public void deleteVehicleInfo(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		VehicleInfo p = (VehicleInfo) session.load(VehicleInfo.class, new Integer(id));
		if (null != p) {
			session.delete(p);
		}
	} 
	
	public List<String> getAllUniqueModels() {
		Session session = this.sessionFactory.getCurrentSession();
		List<String>  modelList = session.createQuery("SELECT DISTINCT model from VehicleInfo").list();
		return modelList;
	}
	
	public List<Integer> getAllUniqueYears() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Integer>  yearList = session.createQuery("SELECT DISTINCT Year from VehicleInfo").list();
		return yearList;
	}

	public List<Float> getAllUniqueConsumptions() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Float>  consumptionList = session.createQuery("SELECT DISTINCT comb_cons from VehicleInfo").list();
		return consumptionList;
	}
	
	public List<VehicleInfo> searchBarFind(String model, int year,  int mid) {
		Session session = this.sessionFactory.getCurrentSession();
		//String searchQ = "FROM VehicleInfo WHERE ('"+ model +"' = 'All' or model = '" + model+
		//		"' )AND('"+year+"'= 'All' or year = "+ year+" )AND("+mid +"= 0 or mid = "+mid +")";    
		String searchSQLquery = "select v.Year,v.mid,v.model,v.VehicleClass,v.EngineSize,v.Cylinders,v.FuelType,v.City,v.Hwy,v.Comb,v.CO2Rating,v.SmogRating,v.vid,make_name FROM VehicleInfo as v left join Make as m on v.mid=m.mid WHERE ('"+ model +"' = 'All' or model = '" + model+
				"' )AND('"+year+"'= 'All' or year = "+ year+" )AND("+mid +"= 0 or v.mid = "+mid +")";
		//List<VehicleInfo>  findList = session.createQuery(searchQ).list();
		List<VehicleInfo>  findList = session.createSQLQuery(searchSQLquery).addEntity(VehicleInfo.class).list();
		return findList;
	}
	
	public List<VehicleInfo> makeGetModelsInfo(int mid) {
		Session session = this.sessionFactory.getCurrentSession();
		String searchQ = "select * FROM VehicleInfo WHERE mid = " + mid;  
		List<VehicleInfo>  infoList = session.createSQLQuery(searchQ).list();
		return infoList;
	}
	
	public List<VehicleInfo> uidFindVehicleInfos(int uid) {
		Session session = this.sessionFactory.getCurrentSession();
//		String searchSQLquery =  "SELECT * FROM VehicleInfo as v WHERE v.vid IN (SELECT vid FROM Cart c where c.cid = "+cid+")";
		String searchSQLquery =  "select r.Year,r.mid,r.model,r.VehicleClass,r.EngineSize,r.Cylinders,r.FuelType,r.City,r.Hwy,r.Comb,r.CO2Rating,r.SmogRating,r.vid,make_name from (select v.Year,v.mid,v.model,v.VehicleClass,v.EngineSize,v.Cylinders,v.FuelType,v.City,v.Hwy,v.Comb,v.CO2Rating,v.SmogRating,v.vid,make_name from VehicleInfo v left join Make m on v.mid = m.mid) as r left join Cart c on r.vid = c.vid where c.cid ="
				+"(select cid from Buyer where uid = " + uid +")";
		List<VehicleInfo>  findList = session.createSQLQuery(searchSQLquery).addEntity(VehicleInfo.class).list();
		return findList;
	}
}
