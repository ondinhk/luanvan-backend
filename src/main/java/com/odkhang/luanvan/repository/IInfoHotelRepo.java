package com.odkhang.luanvan.repository;

import com.odkhang.luanvan.model.infoHotel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IInfoHotelRepo extends MongoRepository<infoHotel, String> {
}
