package com.vipindubey.springrestjpa.controller;

import com.vipindubey.springrestjpa.model.BuildingLimit;
import com.vipindubey.springrestjpa.service.BuildingLimitServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.SQLException;

@RestController
@RequestMapping("/buildinglimits")
public class BuildingLimitController {

    @Autowired
    BuildingLimitServiceImpl buildingLimitService;

    @GetMapping
    public @ResponseBody Iterable<BuildingLimit> getAllBuildingLimits() {
        return buildingLimitService.getAllBuildingLimits();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    BuildingLimit createBuldingLimit(@Valid @RequestBody BuildingLimit buildingLimit){
        return buildingLimitService.saveBuildingLimit(buildingLimit);
    }
    @PutMapping("{id}")
    public ResponseEntity<BuildingLimit> updateBuildingLimit(@PathVariable Long id, @RequestBody BuildingLimit buildingLimit) throws SQLException {

       return buildingLimitService.getBuildingLimitById(id).map(savedBuildingLimit -> {
           savedBuildingLimit.setCoordinates(buildingLimit.getCoordinates());
           try {
               BuildingLimit updatedBuildingLimit = buildingLimitService.updateBuildingLimit(savedBuildingLimit);
               return new ResponseEntity<>(updatedBuildingLimit, HttpStatus.OK);
           } catch (SQLException e) {
               e.printStackTrace();
               return new ResponseEntity<>(buildingLimit, HttpStatus.BAD_REQUEST);
           }
       }).orElseGet(() -> ResponseEntity.notFound().build());

    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteBuildingLimit(@PathVariable("id") long id){

        buildingLimitService.deleteBuildingLimit(id);
        return new ResponseEntity<String>("Building limit with id " +id+ " was deleted successfully", HttpStatus.OK);

    }
}
