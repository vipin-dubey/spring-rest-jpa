package com.vipindubey.springrestjpa.util;

import com.vipindubey.springrestjpa.model.BuildingLimit;
import com.vipindubey.springrestjpa.model.HeightPlateau;
import com.vipindubey.springrestjpa.model.SplitBuildingLimit;

import java.util.ArrayList;
import java.util.List;

public class MapBuildingLimitToHeightPlateau {

    public static List<SplitBuildingLimit> process(List<BuildingLimit> buildingLimit, List<HeightPlateau> heightPlateau){
        List<SplitBuildingLimit> splitBuildingLimitList = new ArrayList<SplitBuildingLimit>();
        /* Do the preprocess step that outputs split building limits from the provided list of building limits and height plateaus */
        return splitBuildingLimitList;
    }
}
