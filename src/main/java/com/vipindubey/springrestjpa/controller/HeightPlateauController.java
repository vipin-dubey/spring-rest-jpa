package com.vipindubey.springrestjpa.controller;

import com.vipindubey.springrestjpa.model.BuildingLimit;
import com.vipindubey.springrestjpa.model.HeightPlateau;
import com.vipindubey.springrestjpa.service.HeightPlateauServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.SQLException;

@RestController
@RequestMapping("/heightplateaus")
public class HeightPlateauController {
    @Autowired
    HeightPlateauServiceImpl heightPlateauService;


    @GetMapping
    public @ResponseBody
    Iterable<HeightPlateau> getAllHeightPlateaus() {
        return heightPlateauService.getAllHeightPlateaus();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    HeightPlateau addHeightPlateau(@Valid @RequestBody HeightPlateau heightPlateau){
        return heightPlateauService.saveHeightPlateau(heightPlateau);
    }

    @PutMapping("{id}")
    public ResponseEntity<HeightPlateau> updateHeightPlateau(@PathVariable Long id, @RequestBody HeightPlateau heightPlateau) throws SQLException {

        return heightPlateauService.getHeightPlateauById(id).map(savedHeightPlateau -> {
            savedHeightPlateau.setCoordinatesWithHeight(heightPlateau.getCoordinatesWithHeight());
            try {
                HeightPlateau updatedHeightPlateau = heightPlateauService.updateHeightPlateau(savedHeightPlateau);
                return new ResponseEntity<>(updatedHeightPlateau, HttpStatus.OK);
            } catch (SQLException e) {
                e.printStackTrace();
                return new ResponseEntity<>(heightPlateau, HttpStatus.BAD_REQUEST);
            }
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteBuildingLimit(@PathVariable("id") long id){

        heightPlateauService.deleteHeightPlateau(id);
        return new ResponseEntity<String>("Height plateau with id " +id+ " was deleted successfully", HttpStatus.OK);

    }
}
