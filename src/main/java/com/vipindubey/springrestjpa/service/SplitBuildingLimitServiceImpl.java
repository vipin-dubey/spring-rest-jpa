package com.vipindubey.springrestjpa.service;

import com.vipindubey.springrestjpa.model.BuildingLimit;
import com.vipindubey.springrestjpa.model.HeightPlateau;
import com.vipindubey.springrestjpa.model.SplitBuildingLimit;
import com.vipindubey.springrestjpa.repository.SplitBuildingLimitRepository;
import com.vipindubey.springrestjpa.util.MapBuildingLimitToHeightPlateau;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class SplitBuildingLimitServiceImpl implements  SplitBuildingLimitService{

    @Autowired
    SplitBuildingLimitRepository splitBuildingLimitRepository;

    public List<SplitBuildingLimit> preprocess(List<BuildingLimit> buildingLimit, List<HeightPlateau> heightPlateau){
        return MapBuildingLimitToHeightPlateau.process(buildingLimit, heightPlateau);
    }

    public Iterable<SplitBuildingLimit> addSplitBuildingLimits(List<SplitBuildingLimit> splitBuildingLimit){
        return splitBuildingLimitRepository.saveAll(splitBuildingLimit);
    }

    @Override
    public SplitBuildingLimit saveSplitBuildingLimit(SplitBuildingLimit splitBuildingLimit) {
        return splitBuildingLimitRepository.save(splitBuildingLimit);
    }

    @Override
    public List<SplitBuildingLimit> getAllSplitBuildingLimits() {
        return (List)splitBuildingLimitRepository.findAll();
    }

    @Override
    public Optional<SplitBuildingLimit> getSplitBuildingLimitById(long id) {
        return splitBuildingLimitRepository.findById(id);
    }


    @Override
    public void deleteSplitBuildingLimit(long id) {
        splitBuildingLimitRepository.deleteById(id);
    }
}
