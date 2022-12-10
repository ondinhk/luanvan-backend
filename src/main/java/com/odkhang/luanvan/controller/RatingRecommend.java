package com.odkhang.luanvan.controller;

import com.odkhang.luanvan.model.InfoHotel;
import com.odkhang.luanvan.service.IRatingRecommend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/rate")
public class RatingRecommend {
    @Autowired
    IRatingRecommend iRatingRecommend;

    @PostMapping("/post")
    @ResponseBody
    ResponseEntity<com.odkhang.luanvan.model.RatingRecommend> addRating(@RequestBody Map<String, String> input_user) {
        try {
            int value = Integer.parseInt(input_user.get("rate"));
            String recommend_for = input_user.get("recommend_for");
            String recommend = input_user.get("recommend");
            String comment = input_user.get("comment");
            com.odkhang.luanvan.model.RatingRecommend rate = new com.odkhang.luanvan.model.RatingRecommend();
            rate.setRate(value);
            rate.setRecommend_for(recommend_for);
            rate.setRecommend(recommend);
            rate.setComment(comment);
            com.odkhang.luanvan.model.RatingRecommend response = iRatingRecommend.updateRatingRecommend(rate);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            System.out.println("Wrong recommend" + e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/getAllNumberRating")
    @ResponseBody
    ResponseEntity<Long> getNumberRating() {
        try {
            long response = iRatingRecommend.getNumberRating();
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            System.out.println("Wrong rating" + e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/getValueChartRating")
    @ResponseBody
    ResponseEntity<List<Integer>> getValueChartRating() {
        try {
            List<Integer> response = iRatingRecommend.getValueChartRating();
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            System.out.println("Wrong rating" + e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/getAllRating")
    @ResponseBody
    ResponseEntity<Page<com.odkhang.luanvan.model.RatingRecommend>> getAllRating(@RequestParam int page, @RequestParam int size) {
        try {
            Pageable queryPage = PageRequest.of(page, size);
            Page<com.odkhang.luanvan.model.RatingRecommend> getAllRating = iRatingRecommend.getAllRating(queryPage);
//            List<com.odkhang.luanvan.model.RatingRecommend> getAllRating = iRatingRecommend.findAll();
            if (getAllRating == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            } else {
                return ResponseEntity.status(HttpStatus.OK).body(getAllRating);
            }
        } catch (Exception e) {
            System.out.println("Cannot get hotel" + e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
