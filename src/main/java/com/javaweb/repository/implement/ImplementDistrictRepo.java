package com.javaweb.repository.implement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.springframework.stereotype.Repository;

import com.javaweb.repository.DistrictRepository;
import com.javaweb.repository.entity.DistrictEntity;
import com.javaweb.utils.ConnectionDBUntil;

@Repository
public class ImplementDistrictRepo implements DistrictRepository {

	@Override
	public DistrictEntity findById(Long id) {
		String sqlString = " SELECT * FROM district WHERE id = "+id;
		DistrictEntity districtEntity = new DistrictEntity();
		try(
				Connection connection = ConnectionDBUntil.getConnection();
				Statement statement=connection.createStatement();
				ResultSet resultSet=statement.executeQuery(sqlString)
			){
				while(resultSet.next()) {
					districtEntity.setCode(resultSet.getString("code"));
					districtEntity.setId(id);
					districtEntity.setName(resultSet.getString("name"));
				}
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		return districtEntity;
	}

}
