package com.vipindubey.springrestjpa.controller;

import com.vipindubey.springrestjpa.model.BuildingLimit;
import com.vipindubey.springrestjpa.model.HeightPlateau;
import com.vipindubey.springrestjpa.model.SplitBuildingLimit;
import com.vipindubey.springrestjpa.service.BuildingLimitServiceImpl;
import com.vipindubey.springrestjpa.service.HeightPlateauServiceImpl;
import com.vipindubey.springrestjpa.service.SplitBuildingLimitServiceImpl;
import com.vipindubey.springrestjpa.util.APIRequestWrapper;
import com.vipindubey.springrestjpa.util.APIResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/buldinglimitsandheightplateaus")
public class AppController {

    @Autowired
    BuildingLimitServiceImpl buildingLimitService;
    @Autowired
    HeightPlateauServiceImpl heightPlateauService;
    @Autowired
    SplitBuildingLimitServiceImpl splitBuildingLimitService;

    @PostMapping
    ResponseEntity<APIResponseWrapper> addBuldingLimitsAndHeighPlateaus(@Valid @RequestBody APIRequestWrapper apiRequestWrapper){

        List<BuildingLimit> buildingLimitList = apiRequestWrapper.getBuildingLimits();
        List<HeightPlateau> heightPlateauList = apiRequestWrapper.getHeightPlateaus();

        //Preprocess the input to generate split building limits
        List<SplitBuildingLimit> splitBuildingLimit = splitBuildingLimitService.preprocess(buildingLimitList, heightPlateauList);

        //Add the data to to application
        List<BuildingLimit> savedBuildingLimits = (ArrayList) buildingLimitService.addBuildingLimits(buildingLimitList);
        List<HeightPlateau> savedHeightPlateaus = (ArrayList) heightPlateauService.addHeightPlateauList(heightPlateauList);
        List<SplitBuildingLimit> savedSplitBuildingLimits = (ArrayList) splitBuildingLimitService.addSplitBuildingLimits(splitBuildingLimit);

        //Create a new response with persisted data to the application database
        APIResponseWrapper apiResponseWrapper = new APIResponseWrapper(savedBuildingLimits, savedHeightPlateaus, savedSplitBuildingLimits);

        return new ResponseEntity<APIResponseWrapper>(apiResponseWrapper, HttpStatus.OK);
    }

    @GetMapping
    public @ResponseBody APIResponseWrapper getAllData(){

        List<BuildingLimit> buildingLimitList = (ArrayList)buildingLimitService.getAllBuildingLimits();
        List<HeightPlateau> heightPlateauList = (ArrayList)heightPlateauService.getAllHeightPlateaus();
        List<SplitBuildingLimit> splitBuildingLimitList = (ArrayList)splitBuildingLimitService.getAllSplitBuildingLimits();

        APIResponseWrapper apiResponseWrapper = new APIResponseWrapper(buildingLimitList, heightPlateauList, splitBuildingLimitList);

        return apiResponseWrapper;
    }

}
