package com.javaweb.converter;

import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.javaweb.DTO.BuildingDTO;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.repository.entity.DistrictEntity;
import com.javaweb.repository.implement.ImplementDistrictRepo;
import com.javaweb.repository.implement.ImplementRentAreaRepo;

@Component
public class BuildingConverter {
	@Autowired
	private ImplementDistrictRepo implementDistrictRepo;
	@Autowired
	private ImplementRentAreaRepo implementRentAreaRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	public BuildingDTO convertToBuildingDTO(BuildingEntity x) {
		
		// Can be use Model Mapper but the name must be the same :(
//		BuildingDTO buildingDTO = modelMapper.map(x, BuildingDTO.class);
		
		BuildingDTO buildingDTO =new BuildingDTO();
		//Name of building
		buildingDTO.setNamOfBuilding(x.getName());
		//Address
//		DistrictEntity districtEntity= implementDistrictRepo.findById(x.getDistrictid());			
		buildingDTO.setAddressBuilding(x.getStreet()+","+x.getWard()+","+x.getDistrictEntity().getName());
		// Number of basement
		buildingDTO.setNumberOfBasement(x.getNumberofbasement());
		// Name of Manager
		buildingDTO.setNameOfManager(x.getManagername());
		// Phonenumber of Manager
		buildingDTO.setPhoneOfManager(x.getManagerphonenumber());
		// Area of Floor
		buildingDTO.setFloorArea(x.getFloorarea());
		// Area is free
		buildingDTO.setFreeArea("0");
		//Area for Rent
		String rentAreaString=x.getAreaEntities().stream().map(i->i.getValue().toString()).collect(Collectors.joining(","));
		buildingDTO.setRentArea(rentAreaString);
		//Brokerage FEE
		buildingDTO.setFeeBrokerage(x.getBrokeragefee());
		
		
		return buildingDTO;
	}
}
