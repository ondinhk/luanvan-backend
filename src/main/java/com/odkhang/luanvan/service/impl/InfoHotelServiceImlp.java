package com.odkhang.luanvan.service.impl;

import com.odkhang.luanvan.model.InfoHotel;
import com.odkhang.luanvan.repository.IInfoHotelRepository;
import com.odkhang.luanvan.service.IInfoHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class InfoHotelServiceImlp implements IInfoHotelService {
    @Autowired
    IInfoHotelRepository infoHotelRepo;

    @Override
    public InfoHotel getOneHotel(Long idHouse, Long idLocation) {
        return infoHotelRepo.getOneHotel(idHouse, idLocation);
    }

    @Override
    public Page<InfoHotel> allHotels(Pageable p) {
        return infoHotelRepo.findAll(p);
    }
}
