package com.odkhang.luanvan.service.impl;

import com.odkhang.luanvan.model.imagesHotel;
import com.odkhang.luanvan.repository.IImagesHotelRepo;
import com.odkhang.luanvan.service.IImagesHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class imagesHotelImlp implements IImagesHotelService {

    @Autowired
    IImagesHotelRepo imagesHotelRepo;

    @Override
    public List<imagesHotel> getImageById(Long idHouse) {
        return imagesHotelRepo.findByIdHouse(idHouse);
    }
}
