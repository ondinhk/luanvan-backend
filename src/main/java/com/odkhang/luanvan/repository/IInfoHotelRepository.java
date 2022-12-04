package com.odkhang.luanvan.repository;

import com.odkhang.luanvan.model.InfoHotel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;


public interface IInfoHotelRepository extends MongoRepository<InfoHotel, String> {
    @Query("{'_id': ?0}")
    InfoHotel findHotelById(String id);

    Page<InfoHotel> findByIdLocation(int idLocation, Pageable p);

    @Query(value = "{idLocation: ?0}", count = true)
    Long countNumberHotelInLocation(Long idLocation);
}
