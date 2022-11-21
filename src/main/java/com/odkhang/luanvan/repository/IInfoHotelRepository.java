package com.odkhang.luanvan.repository;

import com.odkhang.luanvan.model.InfoHotels;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;


public interface IInfoHotelRepository extends MongoRepository<InfoHotels, String> {
    @Query("{'_id': ?0}")
    InfoHotels findHotelById(String id);

    Page<InfoHotels> findByIdLocation(int idLocation, Pageable p);
}
