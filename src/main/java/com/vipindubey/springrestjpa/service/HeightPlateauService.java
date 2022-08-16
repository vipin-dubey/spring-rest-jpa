package com.vipindubey.springrestjpa.service;

import com.vipindubey.springrestjpa.model.HeightPlateau;
import com.vipindubey.springrestjpa.repository.HeightPlateauRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeightPlateauService {

    @Autowired
    HeightPlateauRepository heightPlateauRepository;

    public HeightPlateau add(HeightPlateau heightPlateau){
        return heightPlateauRepository.save(heightPlateau);
    }

    public Iterable<HeightPlateau> addHeightPlateauList(List<HeightPlateau> heightPlateauList){
        return heightPlateauRepository.saveAll(heightPlateauList);
    }

    public Iterable<HeightPlateau> list(){
        return heightPlateauRepository.findAll();
    }
}
