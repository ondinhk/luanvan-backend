package com.odkhang.luanvan.repository;

import com.odkhang.luanvan.model.LocationHotel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ILocationsRepository extends MongoRepository<LocationHotel, Long> {
}
