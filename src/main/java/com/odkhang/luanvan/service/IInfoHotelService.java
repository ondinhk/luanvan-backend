package com.odkhang.luanvan.service;

import com.odkhang.luanvan.model.InfoHotels;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IInfoHotelService {
    InfoHotels getHotel(String idHouse);

    Page<InfoHotels> getAllHotels(Pageable p);

    Page<InfoHotels> findAllByIdLocation(int idLocation, Pageable p);

    List<InfoHotels> recommendHotelsMachine(String input, String size, String idLocation);

}
