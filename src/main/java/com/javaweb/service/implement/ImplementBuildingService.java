package com.javaweb.service.implement;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaweb.DTO.BuildingDTO;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.repository.entity.DistrictEntity;
import com.javaweb.repository.implement.ImplementBuidlingRepo;
import com.javaweb.repository.implement.ImplementDistrictRepo;
import com.javaweb.repository.implement.ImplementRentAreaRepo;
import com.javaweb.service.BuildingService;


@Service
public class ImplementBuildingService implements BuildingService{
	@Autowired
	private ImplementBuidlingRepo implementBuidlingRepo;
	@Autowired
	private ImplementDistrictRepo implementDistrictRepo;
	@Autowired
	private ImplementRentAreaRepo implementRentAreaRepo;
	@Override
	public List<BuildingDTO> buildingDTOs(Map<String, Object> params, List<String> typecode) {
		List<BuildingEntity>listBuidBuildingEntities=implementBuidlingRepo.findAllBuildingEntities(params,typecode);
		List<BuildingDTO>listBuildingDTOs= new ArrayList<BuildingDTO>();
		for(BuildingEntity x: listBuidBuildingEntities) {
			BuildingDTO buildingDTO = new BuildingDTO();
			//Name of building
			buildingDTO.setNamOfBuilding(x.getName());
			//Address
			DistrictEntity districtEntity= implementDistrictRepo.findById(x.getDistrictid());			
			buildingDTO.setAddressBuilding(x.getStreet()+","+x.getWard()+","+districtEntity.getName());
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
			String rentAreaString=implementRentAreaRepo.findRentArea(x.getId());
			buildingDTO.setRentArea(rentAreaString);
			//Brokerage FEE
			buildingDTO.setFeeBrokerage(x.getBrokeragefee());
			listBuildingDTOs.add(buildingDTO);

		}
		return listBuildingDTOs;
	}

}
