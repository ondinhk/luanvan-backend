package com.odkhang.luanvan.service.impl;

import com.odkhang.luanvan.model.LocationHotel;
import com.odkhang.luanvan.repository.IInfoHotelRepository;
import com.odkhang.luanvan.repository.ILocationsRepository;
import com.odkhang.luanvan.service.ILocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LocationServiceImlp implements ILocationService {

    @Autowired
    ILocationsRepository locationsRepository;
    @Autowired
    IInfoHotelRepository infoHotelRepository;

    @Override
    public List<LocationHotel> getAllLocation() {
        return locationsRepository.findAll();
    }

    @Override
    public LocationHotel getLocation(int idLocation) {
        return locationsRepository.findByIdLocation(idLocation);
    }

    @Override
    public List<Object> getValueChartLocations() {
        List<LocationHotel> listLocations = locationsRepository.findAll();
        List<String> listName = new ArrayList<String>();
        List<Long> listValues = new ArrayList<Long>();
        Long totalValue = 0L;
        for (LocationHotel locationHotel : listLocations) {
            Long idLocation = locationHotel.getIdLocation();
            Long numberHotel = infoHotelRepository.countNumberHotelInLocation(idLocation);
            String name = locationHotel.getName() + " (" + numberHotel + ")";
            listName.add(name);
            listValues.add(numberHotel);
            totalValue += numberHotel;
        }
        List<Object> response = new ArrayList<Object>();
        response.add(listName);
        response.add(listValues);
        response.add(totalValue);
        return response;
    }
}
