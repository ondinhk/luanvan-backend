package com.odkhang.luanvan.repository;

import com.odkhang.luanvan.model.LocationHotel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface ILocationsRepository extends MongoRepository<LocationHotel, Long> {
    @Query("{'idLocation': ?0}")
    LocationHotel findByIdLocation(int idLocation);
}
