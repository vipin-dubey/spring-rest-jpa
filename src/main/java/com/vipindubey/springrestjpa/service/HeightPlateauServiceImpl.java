package com.vipindubey.springrestjpa.service;

import com.vipindubey.springrestjpa.model.HeightPlateau;
import com.vipindubey.springrestjpa.repository.HeightPlateauRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class HeightPlateauServiceImpl implements HeightPlateauService{

    @Autowired
    HeightPlateauRepository heightPlateauRepository;


    public Iterable<HeightPlateau> addHeightPlateauList(List<HeightPlateau> heightPlateauList){
        return heightPlateauRepository.saveAll(heightPlateauList);
    }


    @Retryable( value = SQLException.class, maxAttempts = 2, backoff = @Backoff(delay = 100))
    @Transactional
    public HeightPlateau updateHeightPlateau(HeightPlateau heightPlateau, Long id) throws SQLException {
        return heightPlateauRepository.save(heightPlateau);
    }

    @Override
    public HeightPlateau saveHeightPlateau(HeightPlateau heightPlateau) {
        HeightPlateau savedHeightPlateau = heightPlateauRepository.save(heightPlateau);
        return savedHeightPlateau;
    }

    @Override
    public List<HeightPlateau> getAllHeightPlateaus() {
        return (List)heightPlateauRepository.findAll();
    }

    @Override
    public Optional<HeightPlateau> getHeightPlateauById(long id) {
        return heightPlateauRepository.findById(id);
    }

    @Override
    public HeightPlateau updateHeightPlateau(HeightPlateau heightPlateau) throws SQLException {
        return heightPlateauRepository.save(heightPlateau);
    }

    @Override
    public void deleteHeightPlateau(long id) {
        heightPlateauRepository.deleteById(id);
    }
}
