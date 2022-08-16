package com.vipindubey.springrestjpa.service;

import com.vipindubey.springrestjpa.model.BuildingLimit;
import com.vipindubey.springrestjpa.model.HeightPlateau;
import com.vipindubey.springrestjpa.model.SplitBuildingLimit;
import com.vipindubey.springrestjpa.repository.SplitBuildingLimitRepository;
import com.vipindubey.springrestjpa.util.MapBuildingLimitToHeightPlateau;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SplitBuildingLimitService {

    @Autowired
    SplitBuildingLimitRepository splitBuildingLimitRepository;

    public List<SplitBuildingLimit> preprocess(List<BuildingLimit> buildingLimit, List<HeightPlateau> heightPlateau){
        return MapBuildingLimitToHeightPlateau.process(buildingLimit, heightPlateau);
    }

    public SplitBuildingLimit add(SplitBuildingLimit splitBuildingLimit){
        return splitBuildingLimitRepository.save(splitBuildingLimit);
    }
    public Iterable<SplitBuildingLimit> addSplitBuildingLimits(List<SplitBuildingLimit> splitBuildingLimit){
        return splitBuildingLimitRepository.saveAll(splitBuildingLimit);
    }


    public Iterable<SplitBuildingLimit> list(){
        return splitBuildingLimitRepository.findAll();
    }
}
