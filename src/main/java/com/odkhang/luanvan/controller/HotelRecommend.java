package com.odkhang.luanvan.controller;


import com.odkhang.luanvan.model.InfoHotel;
import com.odkhang.luanvan.model.RatingRecommend;
import com.odkhang.luanvan.service.IInfoHotelService;
import com.odkhang.luanvan.service.IRatingRecommend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/machines")
public class HotelRecommend {
    @Autowired
    IInfoHotelService infoHotelService;

    @PostMapping("/recommend")
    @ResponseBody
    ResponseEntity<List<InfoHotel>> recommend(@RequestBody Map<String, String> input_user) {
        try {
            String input = input_user.get("input");
            String size = input_user.get("size");
            String idLocation = input_user.get("idLocation");
            List<InfoHotel> response = infoHotelService.recommendHotelsMachine(input, size, idLocation);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            System.out.println("Wrong recommend" + e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


}
