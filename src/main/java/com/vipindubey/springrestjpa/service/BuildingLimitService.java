package com.vipindubey.springrestjpa.service;

import com.vipindubey.springrestjpa.model.BuildingLimit;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface BuildingLimitService {
    BuildingLimit saveBuildingLimit(BuildingLimit buildingLimit);
    List<BuildingLimit> getAllBuildingLimits();
    Optional<BuildingLimit> getBuildingLimitById(long id);
    BuildingLimit updateBuildingLimit(BuildingLimit updatedBuildingLimit) throws SQLException;
    void deleteBuildingLimit(long id);
}
