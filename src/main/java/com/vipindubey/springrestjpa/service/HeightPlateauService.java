package com.vipindubey.springrestjpa.service;

import com.vipindubey.springrestjpa.model.HeightPlateau;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface HeightPlateauService {

    HeightPlateau saveHeightPlateau(HeightPlateau heightPlateau);
    List<HeightPlateau> getAllHeightPlateaus();
    Optional<HeightPlateau> getHeightPlateauById(long id);
    HeightPlateau updateHeightPlateau(HeightPlateau heightPlateau) throws SQLException;
    void deleteHeightPlateau(long id);
}
