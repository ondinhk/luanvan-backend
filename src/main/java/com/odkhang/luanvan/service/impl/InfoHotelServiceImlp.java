package com.odkhang.luanvan.service.impl;

import com.odkhang.luanvan.model.InfoHotel;
import com.odkhang.luanvan.repository.IInfoHotelRepository;
import com.odkhang.luanvan.service.IInfoHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfoHotelServiceImlp implements IInfoHotelService {
    @Autowired
    IInfoHotelRepository infoHotelRepo;

    @Override
    public List<InfoHotel> getAllHotel() {
        return infoHotelRepo.findAll();
    }
}
