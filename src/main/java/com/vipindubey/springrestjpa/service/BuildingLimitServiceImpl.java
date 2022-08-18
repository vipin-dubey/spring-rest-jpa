package com.vipindubey.springrestjpa.service;

import com.vipindubey.springrestjpa.model.BuildingLimit;
import com.vipindubey.springrestjpa.repository.BuildingLimitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class BuildingLimitServiceImpl implements BuildingLimitService {

    @Autowired
    BuildingLimitRepository buildingLimitRepository;

    public Iterable<BuildingLimit> addBuildingLimits(List<BuildingLimit> buildingLimit){
        Iterable<BuildingLimit> savedBuildingLimit = buildingLimitRepository.saveAll(buildingLimit);
        return savedBuildingLimit;
    }

    @Retryable( value = SQLException.class, maxAttempts = 2, backoff = @Backoff(delay = 100))
    @Transactional
    @Override
    public BuildingLimit updateBuildingLimit(BuildingLimit buildingLimit) throws SQLException {
        return buildingLimitRepository.save(buildingLimit);
    }

    @Override
    public BuildingLimit saveBuildingLimit(BuildingLimit buildingLimit) {
        BuildingLimit savedBuildingLimit = buildingLimitRepository.save(buildingLimit);
        return savedBuildingLimit;
    }

    @Override
    public List<BuildingLimit> getAllBuildingLimits() {
        return (List)buildingLimitRepository.findAll();
    }

    @Override
    public Optional<BuildingLimit> getBuildingLimitById(long id) {
        Optional<BuildingLimit> buildingLimit = buildingLimitRepository.findById(id);
        return buildingLimit;
    }


    @Override
    public void deleteBuildingLimit(long id) {
        buildingLimitRepository.deleteById(id);
    }
}
