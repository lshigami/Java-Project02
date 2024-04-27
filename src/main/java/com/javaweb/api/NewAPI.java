package com.javaweb.api;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.DTO.BuildingDTO;
import com.javaweb.repository.entity.DistrictEntity;
import com.javaweb.repository.implement.ImplementDistrictRepo;
import com.javaweb.service.implement.ImplementBuildingService;

@RestController
public class NewAPI {
	@Autowired
	private ImplementBuildingService implementBuildingService;

	@GetMapping(value = "/api/building")
	public List<BuildingDTO> getBuilding(@RequestParam Map<String, Object> params,
			@RequestParam(value = "typeCode", required = false) List<String> typecode) {
		List<BuildingDTO> listbBuildingDTOs = implementBuildingService.buildingDTOs(params, typecode);
		return listbBuildingDTOs;
	}
}
