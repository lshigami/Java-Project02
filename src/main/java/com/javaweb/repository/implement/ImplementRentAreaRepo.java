package com.javaweb.repository.implement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.springframework.stereotype.Repository;

import com.javaweb.repository.RentAreaRepository;
import com.javaweb.repository.entity.DistrictEntity;
import com.javaweb.utils.ConnectionDBUntil;

@Repository
public class ImplementRentAreaRepo implements RentAreaRepository {

	@Override
	public String findRentArea(String buildingid) {
		String ans="";
		String sqlString = " SELECT value FROM rentarea WHERE buildingid = "+buildingid;
		try(
				Connection connection = ConnectionDBUntil.getConnection();
				Statement statement=connection.createStatement();
				ResultSet resultSet=statement.executeQuery(sqlString)
			){
				while(resultSet.next()) {
					ans+=resultSet.getString("value")+",";
				}
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		return ans;
	}


}
