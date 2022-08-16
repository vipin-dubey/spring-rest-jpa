package com.vipindubey.springrestjpa;

import com.vipindubey.springrestjpa.model.BuildingLimit;
import com.vipindubey.springrestjpa.model.Coordinate;
import com.vipindubey.springrestjpa.model.CoordinateWithHeight;
import com.vipindubey.springrestjpa.model.HeightPlateau;
import com.vipindubey.springrestjpa.service.BuildingLimitService;
import com.vipindubey.springrestjpa.service.HeightPlateauService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.security.Policy;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@SpringBootApplication
public class SpringRestJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringRestJpaApplication.class, args);
    }

    /*@Bean
    public CommandLineRunner run(BuildingLimitService buildingLimitService) throws Exception {
        return (String[] args) -> {

         // Create a list to hold coordinates that belong to a building limit
            List<Coordinate> coordinates = new ArrayList<Coordinate>(5);

            //add dummy data
            for(int i=0; i < 5; i++){
                coordinates.add(new Coordinate(i+1,i+1));
            }

            //Add the first coordinate from the list back as the last coordinate to make it a polygon.
            coordinates.add(new Coordinate(1,1));

            //Create a new building limist using the coordinates
            BuildingLimit buildingLimit = new BuildingLimit(coordinates);

            //Persist it to database
            buildingLimitService.add(buildingLimit);
        };
    }

   @Bean
    public CommandLineRunner run1(HeightPlateauService heightPlateauService) throws Exception {
        return (String[] args) -> {

            // Create a list to hold coordinates with height that belong to a height plateau
            List<CoordinateWithHeight> coordinatesWithHeight = new ArrayList<CoordinateWithHeight>(5);

            //Add dummy data
            for(int i=1; i < 5; i++){
                coordinatesWithHeight.add(new CoordinateWithHeight(i,i, i + 10));
            }
            //Add the first coordinate from the list back as the last coordinate to make it a polygon.
            coordinatesWithHeight.add(new CoordinateWithHeight(1,1, 11));

            //Create a new building limist using the coordinates
            HeightPlateau heightPlateau = new HeightPlateau(coordinatesWithHeight);

            //Persist it to database
            heightPlateauService.add(heightPlateau);
        };
    }*/


}
