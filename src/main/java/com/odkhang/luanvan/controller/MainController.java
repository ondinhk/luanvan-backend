package com.odkhang.luanvan.controller;

import com.odkhang.luanvan.model.InfoHotel;
import com.odkhang.luanvan.model.LocationHotel;
import com.odkhang.luanvan.service.IInfoHotelService;
import com.odkhang.luanvan.service.ILocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class MainController {
    @Autowired
    IInfoHotelService infoHotelService;
    @Autowired
    ILocationService locationService;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @ResponseBody
    ResponseEntity<List<InfoHotel>> getAll() {
        try {
            List<InfoHotel> infoAll = infoHotelService.getAllHotel();
            if (infoAll.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            } else {
                return ResponseEntity.status(HttpStatus.OK).body(infoAll);
            }
        } catch (Exception e) {
            System.out.println("Cannot get all info " + e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @RequestMapping(value = "/getLocations", method = RequestMethod.GET)
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
