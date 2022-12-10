package com.odkhang.luanvan.service;

import com.odkhang.luanvan.model.RatingRecommend;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IRatingRecommend {

    RatingRecommend updateRatingRecommend(RatingRecommend rate);

    Page<com.odkhang.luanvan.model.RatingRecommend> getAllRating(Pageable p);

    List<com.odkhang.luanvan.model.RatingRecommend> findAll();
    long getNumberRating();

    List<Integer> getValueChartRating();
}
