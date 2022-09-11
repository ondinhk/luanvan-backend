package com.odkhang.luanvan.controller;

import com.odkhang.luanvan.model.InfoHotel;
import com.odkhang.luanvan.repository.IInfoHotelRepo;
import com.odkhang.luanvan.service.IInfoHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class MainController {
    @Autowired
    IInfoHotelService infoHotelService;

    @RequestMapping(value = "/all")
    ResponseEntity<List<InfoHotel>> getAll() {
        List<InfoHotel> linkImage = infoHotelService.getAllHotel();
        if (linkImage.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(linkImage);
        }
    }
}
