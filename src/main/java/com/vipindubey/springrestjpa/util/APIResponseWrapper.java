package com.vipindubey.springrestjpa.util;

import com.vipindubey.springrestjpa.model.BuildingLimit;
import com.vipindubey.springrestjpa.model.HeightPlateau;
import com.vipindubey.springrestjpa.model.SplitBuildingLimit;

import java.util.List;

public class APIResponseWrapper {

    List<BuildingLimit> buildingLimits;
    List<HeightPlateau> heightPlateaus;
    List<SplitBuildingLimit> splitBuildingLimits;

    public APIResponseWrapper(List<BuildingLimit> buildingLimits, List<HeightPlateau> heightPlateaus, List<SplitBuildingLimit> splitBuildingLimits) {
        this.buildingLimits = buildingLimits;
        this.heightPlateaus = heightPlateaus;
        this.splitBuildingLimits = splitBuildingLimits;
    }

    public List<BuildingLimit> getBuildingLimits() {
        return buildingLimits;
    }

    public List<HeightPlateau> getHeightPlateaus() {
        return heightPlateaus;
    }

    public List<SplitBuildingLimit> getSplitBuildingLimits() {
        return splitBuildingLimits;
    }

    public void setBuildingLimits(List<BuildingLimit> buildingLimits) {
        this.buildingLimits = buildingLimits;
    }

    public void setHeightPlateaus(List<HeightPlateau> heightPlateaus) {
        this.heightPlateaus = heightPlateaus;
    }

    public void setSplitBuildingLimits(List<SplitBuildingLimit> splitBuildingLimits) {
        this.splitBuildingLimits = splitBuildingLimits;
    }


}
