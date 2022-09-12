package com.odkhang.luanvan.service.impl;

import com.odkhang.luanvan.model.infoHotel;
import com.odkhang.luanvan.repository.IImagesHotelRepo;
import com.odkhang.luanvan.repository.IInfoHotelRepo;
import com.odkhang.luanvan.service.IInfoHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class infoHotelImlp implements IInfoHotelService {
    @Autowired
    IInfoHotelRepo infoHotelRepo;
    @Autowired
    IImagesHotelRepo infoImagesHotelRepo;

    @Override
    public List<infoHotel> getAllHotel() {
        return infoHotelRepo.findAll();
    }
}
