package com.odkhang.luanvan.controller;

import com.odkhang.luanvan.model.InfoHotels;
import com.odkhang.luanvan.service.IInfoHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/hotel")
public class HotelsController {
    @Autowired
    IInfoHotelService infoHotelService;

    @GetMapping("/getHotel")
    @ResponseBody
    ResponseEntity<InfoHotels> getHotel(@RequestParam String idHotel) {
        try {
            InfoHotels infoHotels = infoHotelService.getHotel(idHotel);
            if (infoHotels == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            } else {
                return ResponseEntity.status(HttpStatus.OK).body(infoHotels);
            }
        } catch (Exception e) {
            System.out.println("Cannot get hotel locations" + e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/getAllHotels")
    @ResponseBody
    ResponseEntity<Page<InfoHotels>> getListHotels(@RequestParam int page, @RequestParam int size) {
        try {
            Pageable queryPage = PageRequest.of(page, size);
            Page<InfoHotels> listHotels = infoHotelService.getAllHotels(queryPage);
            if (listHotels == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            } else {
                return ResponseEntity.status(HttpStatus.OK).body(listHotels);
            }
        } catch (Exception e) {
            System.out.println("Cannot get hotel" + e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/getAllHotelsByLocation")
    @ResponseBody
    ResponseEntity<Page<InfoHotels>> getAllHotelsByLocation(@RequestParam int page, @RequestParam int size
            , @RequestParam int idLocation, @RequestParam String filterCommend) {
        try {
            // Min Cost
            Pageable queryPage;
            if (filterCommend.equals("maxComment")) {
                queryPage = PageRequest.of(page, size, Sort.by("number_reviews").descending());
            } else {
                queryPage = PageRequest.of(page, size, Sort.by("rate").descending());
            }
            Page<InfoHotels> listHotels = infoHotelService.findAllByIdLocation(idLocation, queryPage);
            if (listHotels == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            } else {
                return ResponseEntity.status(HttpStatus.OK).body(listHotels);
            }
        } catch (Exception e) {
            System.out.println("Cannot get hotel" + e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
