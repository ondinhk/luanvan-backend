package com.odkhang.luanvan.repository;

import com.odkhang.luanvan.model.InfoHotel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;


public interface IInfoHotelRepository extends MongoRepository<InfoHotel, String> {
    @Query("{'idHouse': ?0, 'idLocation': ?1}")
    InfoHotel getOneHotel(Long idHouse, Long idLocation);

}
