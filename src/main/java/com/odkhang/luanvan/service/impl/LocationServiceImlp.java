package com.odkhang.luanvan.service.impl;

import com.odkhang.luanvan.model.LocationHotel;
import com.odkhang.luanvan.repository.ILocationsRepository;
import com.odkhang.luanvan.service.ILocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImlp implements ILocationService {

    @Autowired
    ILocationsRepository locationsRepository;

    @Override
    public List<LocationHotel> getAllLocation() {
        return locationsRepository.findAll();
    }

    @Override
    public LocationHotel getLocation(int idLocation) {
        return locationsRepository.findByIdLocation(idLocation);
    }
}
