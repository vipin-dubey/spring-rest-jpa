package com.vipindubey.springrestjpa.service;

import com.vipindubey.springrestjpa.model.SplitBuildingLimit;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface SplitBuildingLimitService {

    SplitBuildingLimit saveSplitBuildingLimit(SplitBuildingLimit splitBuildingLimit);
    List<SplitBuildingLimit> getAllSplitBuildingLimits();
    Optional<SplitBuildingLimit> getSplitBuildingLimitById(long id);
    void deleteSplitBuildingLimit(long id);
}