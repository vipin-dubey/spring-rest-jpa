package com.vipindubey.springrestjpa.util;

import com.vipindubey.springrestjpa.model.BuildingLimit;
import com.vipindubey.springrestjpa.model.HeightPlateau;

import javax.validation.constraints.NotNull;
import java.util.List;

public class APIRequestWrapper {

    @NotNull
    List<BuildingLimit> buildingLimits;
    @NotNull
    List<HeightPlateau> heightPlateaus;

    public List<BuildingLimit> getBuildingLimits() {
        return buildingLimits;
    }

    public List<HeightPlateau> getHeightPlateaus() {
        return heightPlateaus;
    }

    public void setBuildingLimits(List<BuildingLimit> buildingLimits) {
        this.buildingLimits = buildingLimits;
    }

    public void setHeightPlateaus(List<HeightPlateau> heightPlateaus) {
        this.heightPlateaus = heightPlateaus;
    }

    @Override
    public String toString() {
        return "APIRequestWrapper{" +
                "buildingLimit=" + buildingLimits +
                ", heightPlateau=" + heightPlateaus +
                '}';
    }
}
