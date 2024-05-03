package com.javaweb.service.implement;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaweb.DTO.BuildingDTO;
import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.converter.BuildingConverter;
import com.javaweb.converter.BuildingSearchBuilderConverter;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.repository.entity.DistrictEntity;
import com.javaweb.repository.implement.ImplementBuidlingRepo;
import com.javaweb.repository.implement.ImplementDistrictRepo;
import com.javaweb.repository.implement.ImplementRentAreaRepo;
import com.javaweb.service.BuildingService;


@Service
public class ImplementBuildingService implements BuildingService{
	@Autowired
	private BuildingRepository buildingRepository;
	@Autowired
	private BuildingConverter buildingConverter;
	@Autowired 
	private BuildingSearchBuilderConverter buildingSearchBuilderConverter;
	@Override
	public List<BuildingDTO> buildingDTOs(Map<String, Object> params, List<String> typecode) {
		
		BuildingSearchBuilder buildingSearchBuilder =buildingSearchBuilderConverter.toBuildingSearchBuilder(params, typecode);
		List<BuildingEntity>listBuidBuildingEntities=buildingRepository.findAllBuildingEntities( buildingSearchBuilder );
		List<BuildingDTO>listBuildingDTOs= new ArrayList<BuildingDTO>();
		for(BuildingEntity x: listBuidBuildingEntities) {
			BuildingDTO buildingDTO =buildingConverter.convertToBuildingDTO(x);
			listBuildingDTOs.add(buildingDTO);
		}
		return listBuildingDTOs;
	}

}
