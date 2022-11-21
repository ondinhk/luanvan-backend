package com.odkhang.luanvan.service;

import com.odkhang.luanvan.model.LocationHotel;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface ILocationService {
    List<LocationHotel> getAllLocation();

    LocationHotel getLocation(int idLocation);

}
