package com.odkhang.luanvan.repository;

import com.odkhang.luanvan.model.RatingRecommend;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface IRatingRecommendRepository extends MongoRepository<RatingRecommend, String> {
    List<RatingRecommend> getAllRatingByRate(int rate);
}
