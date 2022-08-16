package com.vipindubey.springrestjpa.service;

import com.vipindubey.springrestjpa.model.BuildingLimit;
import com.vipindubey.springrestjpa.repository.BuildingLimitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BuildingLimitService {

    @Autowired
    BuildingLimitRepository buildingLimitRepository;

    public BuildingLimit add(BuildingLimit buildingLimit){
        BuildingLimit savedBuildingLimit = buildingLimitRepository.save(buildingLimit);
        return savedBuildingLimit;
    }

    public Iterable<BuildingLimit> addBuildingLimits(List<BuildingLimit> buildingLimit){
        Iterable<BuildingLimit> savedBuildingLimit = buildingLimitRepository.saveAll(buildingLimit);
        return savedBuildingLimit;
    }

    public Optional<BuildingLimit> findBuildingLimitById(Long id){
        Optional<BuildingLimit> buildingLimit = buildingLimitRepository.findById(id);
        return buildingLimit;
    }

    public Iterable<BuildingLimit> list(){
        return buildingLimitRepository.findAll();
    }

    public BuildingLimit updateBuildingLimit(BuildingLimit patchedBuildingLimit, Long id) {
        return buildingLimitRepository.findById(patchedBuildingLimit.getId()).map(buildingLimit -> {
            buildingLimit.setCoordinates(patchedBuildingLimit.getCoordinates());
            return buildingLimitRepository.save(buildingLimit);
        }).orElseGet(() -> {
            patchedBuildingLimit.setId(id);
            return buildingLimitRepository.save(patchedBuildingLimit);
        });

    }
}
