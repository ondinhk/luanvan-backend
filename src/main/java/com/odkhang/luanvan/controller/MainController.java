package com.odkhang.luanvan.controller;

import com.odkhang.luanvan.model.imagesHotel;
import com.odkhang.luanvan.model.infoHotel;
import com.odkhang.luanvan.service.IImagesHotelService;
import com.odkhang.luanvan.service.IInfoHotelService;
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
    IImagesHotelService iImagesHotelService;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @ResponseBody
    ResponseEntity<List<infoHotel>> getAll() {
        try {
            List<infoHotel> infoAll = infoHotelService.getAllHotel();
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

    @RequestMapping(value = "/getImages/{idHouse}", method = RequestMethod.GET)
    @ResponseBody
    ResponseEntity<List<imagesHotel>> getImageById(@PathVariable Long idHouse) {
        try {
            List<imagesHotel> images = iImagesHotelService.getImageById(idHouse);
            if (images == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            } else {
                return ResponseEntity.status(HttpStatus.OK).body(images);
            }
        } catch (Exception e) {
            System.out.println("Cannot get images with idHouse" + idHouse + e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
