package com.javaweb.repository;

import java.util.List;
import java.util.Map;

import com.javaweb.repository.entity.BuildingEntity;

public interface BuildingRepository {
	List<BuildingEntity>findAllBuildingEntities(Map<String, Object> params,List<String>typecode);
}
