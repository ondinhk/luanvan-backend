package com.odkhang.luanvan.controller;


import com.odkhang.luanvan.model.InfoHotels;
import com.odkhang.luanvan.service.IInfoHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/machines")
public class HotelRecommend {
    @Autowired
    IInfoHotelService infoHotelService;

    @PostMapping("/recommend")
    @ResponseBody
    ResponseEntity<List<InfoHotels>> recommend(@RequestBody Map<String, String> input_user) {
        try {
            String input = input_user.get("input");
            String size = input_user.get("size");
            String idLocation = input_user.get("idLocation");
            List<InfoHotels> response = infoHotelService.recommendHotelsMachine(input, size, idLocation);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            System.out.println("Cannot get hotel locations" + e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
