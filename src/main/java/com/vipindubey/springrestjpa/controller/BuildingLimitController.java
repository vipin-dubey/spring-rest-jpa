package com.vipindubey.springrestjpa.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import com.vipindubey.springrestjpa.exception.BuildingLimitNotFoundException;
import com.vipindubey.springrestjpa.model.BuildingLimit;
import com.vipindubey.springrestjpa.service.BuildingLimitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class BuildingLimitController {

    @Autowired
    BuildingLimitService buildingLimitService;

    ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping(path="/buildinglimits")
    public @ResponseBody Iterable<BuildingLimit> getAllBuildingLimits() {
        return buildingLimitService.list();
    }

    @RequestMapping(value = "/buildinglimit", method = RequestMethod.POST)
    ResponseEntity<BuildingLimit> addBuldingLimit(@Valid @RequestBody BuildingLimit buildingLimit){
        BuildingLimit result = buildingLimitService.add(buildingLimit);
        return new ResponseEntity<BuildingLimit>(result, HttpStatus.OK);
    }
    @PutMapping(path = "/buildinglimit/{id}", consumes = "application/json-patch+json")
    public ResponseEntity<BuildingLimit> updateBuildingLimit(@PathVariable Long id, @RequestBody BuildingLimit buildingLimit) {
        BuildingLimit result = buildingLimitService.updateBuildingLimit(buildingLimit, id);
        return ResponseEntity.ok(result);

    }
}
