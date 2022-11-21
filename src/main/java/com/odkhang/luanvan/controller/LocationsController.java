package com.odkhang.luanvan.controller;

import com.odkhang.luanvan.model.LocationHotel;
import com.odkhang.luanvan.service.ILocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/location")
public class LocationsController {
    @Autowired
    ILocationService locationService;

    @RequestMapping(value = "/getLocation", method = RequestMethod.GET)
    @ResponseBody
    ResponseEntity<LocationHotel> getLocation(@RequestParam int idLocation) {
        try {
            LocationHotel location = locationService.getLocation(idLocation);

            if (location == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            } else {
                return ResponseEntity.status(HttpStatus.OK).body(location);
            }
        } catch (Exception e) {
            System.out.println("Cannot get location" + e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @RequestMapping(value = "/getAllLocations", method = RequestMethod.GET)
    @ResponseBody
    ResponseEntity<List<LocationHotel>> getAllLocations() {
        try {
            List<LocationHotel> locations = locationService.getAllLocation();
            if (locations == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            } else {
                return ResponseEntity.status(HttpStatus.OK).body(locations);
            }
        } catch (Exception e) {
            System.out.println("Cannot get all locations" + e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }



}
