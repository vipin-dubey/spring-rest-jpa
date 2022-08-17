package com.vipindubey.springrestjpa.controller;

import com.vipindubey.springrestjpa.model.BuildingLimit;
import com.vipindubey.springrestjpa.model.HeightPlateau;
import com.vipindubey.springrestjpa.service.HeightPlateauService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class HeightPlateauController {
    @Autowired
    HeightPlateauService heightPlateauService;


    @GetMapping(path="/heightplateau/all")
    public @ResponseBody
    Iterable<HeightPlateau> getAllHeightPlateaus() {
        return heightPlateauService.list();
    }

    @RequestMapping(value = "/heightplateau", method = RequestMethod.POST)
    ResponseEntity<HeightPlateau> addBuldingLimit(@Valid @RequestBody HeightPlateau heightPlateau){
        HeightPlateau result = heightPlateauService.add(heightPlateau);
        return new ResponseEntity<HeightPlateau>(result, HttpStatus.OK);
    }
}
