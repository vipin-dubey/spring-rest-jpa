package com.vipindubey.springrestjpa.repository;

import com.vipindubey.springrestjpa.model.Coordinate;
import org.springframework.data.repository.CrudRepository;

public interface CoordinateRepository extends CrudRepository<Coordinate, Long> {
}
