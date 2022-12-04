package com.odkhang.luanvan.service;

import com.odkhang.luanvan.model.InfoHotel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IInfoHotelService {
    InfoHotel getHotel(String idHouse);

    Page<InfoHotel> getAllHotels(Pageable p);

    Page<InfoHotel> findAllByIdLocation(int idLocation, Pageable p);

    List<InfoHotel> recommendHotelsMachine(String input, String size, String idLocation);

    Long countNumberHotelInLocation(Long idLocation);
}
