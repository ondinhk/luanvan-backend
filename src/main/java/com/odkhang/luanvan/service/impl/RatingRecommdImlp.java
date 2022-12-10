package com.odkhang.luanvan.service.impl;

import com.odkhang.luanvan.model.RatingRecommend;
import com.odkhang.luanvan.repository.IRatingRecommendRepository;
import com.odkhang.luanvan.service.IRatingRecommend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RatingRecommdImlp implements IRatingRecommend {
    @Autowired
    IRatingRecommendRepository iRatingRecommendRepository;

    @Override
    public RatingRecommend updateRatingRecommend(RatingRecommend rate) {
        return iRatingRecommendRepository.save(rate);
    }

    @Override
    public Page<com.odkhang.luanvan.model.RatingRecommend> getAllRating(Pageable p) {
        return iRatingRecommendRepository.findAll(p);
    }
    @Override
    public List<com.odkhang.luanvan.model.RatingRecommend> findAll() {
        return iRatingRecommendRepository.findAll();
    }

    @Override
    public long getNumberRating() {
        return iRatingRecommendRepository.count();
    }

    @Override
    public List<Integer> getValueChartRating() {
        List<Integer> listValues = new ArrayList<Integer>();
        for (int i = 1; i <= 5; i++) {
            int rate = getNumberRatingByRate(i);
            listValues.add(rate);
        }
        return listValues;
    }

    private int getNumberRatingByRate(int rate) {
        List<RatingRecommend> list = iRatingRecommendRepository.getAllRatingByRate(rate);

        return list.size();
    }
}
