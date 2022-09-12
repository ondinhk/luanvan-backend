package com.odkhang.luanvan.repository;

import com.odkhang.luanvan.model.imagesHotel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface IImagesHotelRepo extends MongoRepository<imagesHotel, Long> {
    List<imagesHotel> findByIdHouse(Long idHouse);
}
