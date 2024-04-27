package com.javaweb.repository.implement;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.utils.ArrayValidParamUltil;
import com.javaweb.utils.ConnectionDBUntil;
import com.javaweb.utils.StringValidParamUntil;


@Repository
public class ImplementBuidlingRepo implements BuildingRepository {
	
	public void joinWith(BuildingSearchBuilder builder,StringBuilder sql) {
		Long rentAreaFrom =builder.getAreaFrom();
		Long rentAreaTo = builder.getAreaTo();
		Long staffId =builder.getStaffId();
	    List<String> typeCodeList = builder.getTypeCodeList();

		if(rentAreaFrom!=null || rentAreaTo!=null) sql.append(" JOIN rentarea ra ON ra.buildingid=b.id ");
		if(staffId!=null) sql.append(" JOIN assignmentbuilding ab ON ab.buildingid=b.id ");
		if(ArrayValidParamUltil.isExistParam(typeCodeList)) sql.append(" JOIN buildingrenttype brt ON b.id=brt.buildingid JOIN renttype rt ON rt.id=brt.renttypeid ");
		
	}
	public void joinWhere(BuildingSearchBuilder builder,StringBuilder sql) {
		try {
			Field[] fields = BuildingSearchBuilder.class.getDeclaredFields();
			for(Field x:fields) {		
				x.setAccessible(true);
				if(x.get(builder) == null) {
                    continue;
                }
				String fieldName = x.getName();
				if(!fieldName.startsWith("area") && !fieldName.equals("staffId") && !fieldName.startsWith("rentPrice") && !fieldName.equals("typeCodeList") ) {
					
					String value = x.get(builder).toString();
					if(StringValidParamUntil.isExistParam(value)) {
						
						// is digit
						if(value.matches("\\d+")) {
							sql.append(" AND b."+fieldName+" = "+value);
						}else {
							sql.append(" AND b. " +fieldName+" LIKE '%"+ value+"%' ");
						}
						
					}
					
				}
				if(fieldName.equals("staffId")) {
					String data = x.get(builder).toString();
					if(StringValidParamUntil.isExistParam(data)) {
						sql.append(" AND ab.staffid = "+data);
					}
				}
				else if(fieldName.equals("areaFrom")) {
					System.out.println("OK");
					String data = x.get(builder).toString();
					System.out.println(data);
					if(StringValidParamUntil.isExistParam(data)) {
						sql.append(" AND ra.value >= " +data);
					}
				}
				else if(fieldName.equals("areaTo")) {
					String data = x.get(builder).toString();
					if(StringValidParamUntil.isExistParam(data)) {
						sql.append(" AND ra.value <= " +data);
					}
				}
				else if(fieldName.equals("rentPriceFrom")) {
					String data = x.get(builder).toString();
					if(StringValidParamUntil.isExistParam(data)) {
						sql.append(" AND b.rentprice >= " +data);
					}
				}
				else if(fieldName.equals("rentPriceTo")) {
					String data = x.get(builder).toString();
					if(StringValidParamUntil.isExistParam(data)) {
						sql.append(" AND b.rentprice <= " +data);
					}
				}
				if(fieldName.equals("typeCodeList") && ArrayValidParamUltil.isExistParam(builder.getTypeCodeList())) {
			        String result = "IN (\"" + String.join("\",\"", builder.getTypeCodeList()) + "\")";
			        sql.append(" AND rt.code " +result);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	@Override
	public List<BuildingEntity> findAllBuildingEntities(BuildingSearchBuilder builder) {
		StringBuilder sql = new StringBuilder(" SELECT DISTINCT b.* FROM BUILDING b ");
		joinWith(builder, sql);
		StringBuilder where = new StringBuilder(" WHERE 1=1 ");
		joinWhere(builder, where);
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
