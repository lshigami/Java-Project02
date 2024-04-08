package com.javaweb.repository.implement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.utils.ArrayValidParamUltil;
import com.javaweb.utils.ConnectionDBUntil;
import com.javaweb.utils.StringValidParamUntil;


@Repository
public class ImplementBuidlingRepo implements BuildingRepository {
	
	public void joinWith(Map<String, Object> params, List<String> typecode,StringBuilder sql) {
		String rentAreaFrom =(String) params.get("areaFrom");
		String rentAreaTo = (String) params.get("areaTo");
		String staffId =(String)params.get("staffId");
		
		if(StringValidParamUntil.isExistParam(rentAreaFrom) || StringValidParamUntil.isExistParam(rentAreaTo) ) sql.append(" JOIN rentarea ra ON ra.buildingid=b.id ");
		if(StringValidParamUntil.isExistParam(staffId)) sql.append(" JOIN assignmentbuilding ab ON ab.buildingid=b.id ");
		if(ArrayValidParamUltil.isExistParam(typecode)) sql.append(" JOIN buildingrenttype brt ON b.id=brt.buildingid JOIN renttype rt ON rt.id=brt.renttypeid ");
		
	}
	public void joinWhere(Map<String, Object> params, List<String> typecode,StringBuilder sql) {
		for(Map.Entry<String,Object> x : params.entrySet()) {
			System.out.println(x.getKey());
			if(!x.getKey().startsWith("area") && !x.getKey().equals("staffId") && !x.getKey().startsWith("rentPrice") && !x.getKey().equals("typeCode") ) {
				String value =(String) x.getValue();
				if(StringValidParamUntil.isExistParam(value)) {
					// is digit
					if(value.matches("\\d+")) {
						sql.append(" AND b."+x.getKey()+" = "+value);
					}else {
						sql.append(" AND b. " +x.getKey()+" LIKE '%"+ value+"%' ");
					}
				}
			}
			if(x.getKey().equals("staffId")) {
				String data=(String)x.getValue();
				if(StringValidParamUntil.isExistParam(data)) {
					sql.append(" AND ab.staffid = "+data);
				}
			}
			if(x.getKey().equals("areaFrom")) {
				String data=(String)x.getValue();
				if(StringValidParamUntil.isExistParam(data)) {
					sql.append(" AND ra.value >= " +data);
				}
			}
			if(x.getKey().equals("areaTo")) {
				String data=(String)x.getValue();
				if(StringValidParamUntil.isExistParam(data)) {
					sql.append(" AND ra.value <= " +data);
				}
			}
			if(x.getKey().equals("rentPriceFrom")) {
				String data=(String)x.getValue();
				if(StringValidParamUntil.isExistParam(data)) {
					sql.append(" AND b.rentprice >= " +data);
				}
			}
			if(x.getKey().equals("rentPriceTo")) {
				String data=(String)x.getValue();
				if(StringValidParamUntil.isExistParam(data)) {
					sql.append(" AND b.rentprice <= " +data);
				}
			}
			if(ArrayValidParamUltil.isExistParam(typecode)) {
		        String result = "IN (\"" + String.join("\",\"", typecode) + "\")";
		        sql.append(" AND rt.code " +result);
			}
			
		}
	}
	@Override
	public List<BuildingEntity> findAllBuildingEntities(Map<String, Object> params, List<String> typecode) {
		StringBuilder sql = new StringBuilder(" SELECT DISTINCT b.* FROM BUILDING b ");
		joinWith(params, typecode, sql);
		StringBuilder where = new StringBuilder(" WHERE 1=1 ");
		joinWhere(params, typecode, where);
		sql.append(where);
		System.out.println(sql.toString());
		List<BuildingEntity>listbBuildingEntities=new ArrayList<BuildingEntity>();
		try(
			Connection connection = ConnectionDBUntil.getConnection();
			Statement statement=connection.createStatement();
			ResultSet resultSet=statement.executeQuery(sql.toString())
		){
			while(resultSet.next()) {
				BuildingEntity buildingEntity=new BuildingEntity();
				buildingEntity.setId(resultSet.getString("id"));
				buildingEntity.setName(resultSet.getString("name"));
				buildingEntity.setStreet(resultSet.getString("street"));
				buildingEntity.setWard(resultSet.getString("ward"));
				buildingEntity.setDistrictid(resultSet.getString("districtid"));
				buildingEntity.setNumberofbasement(resultSet.getString("numberofbasement"));
				buildingEntity.setFloorarea(resultSet.getString("floorarea"));
				buildingEntity.setRentprice(resultSet.getString("rentprice"));
				buildingEntity.setRentpricedescription(resultSet.getString("rentpricedescription"));
				buildingEntity.setManagername(resultSet.getString("managername"));
				buildingEntity.setManagerphonenumber(resultSet.getString("managerphonenumber"));
				listbBuildingEntities.add(buildingEntity);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return listbBuildingEntities;
	}
	
}
