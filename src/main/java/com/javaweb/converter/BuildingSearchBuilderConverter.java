package com.javaweb.converter;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.utils.MapUltil;
@Component
public class BuildingSearchBuilderConverter {
	public BuildingSearchBuilder toBuildingSearchBuilder(Map<String, Object> params, List<String> typecode){
		BuildingSearchBuilder buildingSearchBuilder=new BuildingSearchBuilder.Builder()
				.setName(MapUltil.getObject(params, "name", String.class))
				.setFloorArea(MapUltil.getObject(params, "floorarea", Long.class))
				.setWard(MapUltil.getObject(params, "ward", String.class))
				.setStreet(MapUltil.getObject(params, "street", String.class))
				.setDistrictId(MapUltil.getObject(params, "districtid", Long.class))
				.setNumberOfBasement(MapUltil.getObject(params, "numberofbasement", Long.class))
				.setTypeCodeList(typecode)
				.setManagerName(MapUltil.getObject(params, "managername", String.class))
				.setManagerPhone(MapUltil.getObject(params, "managerphonenumber", String.class))
				.setRentPriceFrom(MapUltil.getObject(params, "rentPriceFrom", Long.class))
				.setRentPriceTo(MapUltil.getObject(params, "rentPriceTo", Long.class))
				.setAreaFrom(MapUltil.getObject(params, "areaFrom", Long.class))
				.setAreaTo(MapUltil.getObject(params, "areaTo", Long.class))
				.setStaffId(MapUltil.getObject(params, "staffId", Long.class))
				.build();
														
														
		return buildingSearchBuilder;
	}
}
