package com.odkhang.luanvan.repository;

import com.odkhang.luanvan.model.InfoHotel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IInfoHotelRepo extends MongoRepository<InfoHotel, String> {
}
