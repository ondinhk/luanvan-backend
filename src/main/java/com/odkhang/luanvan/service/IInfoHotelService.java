package com.odkhang.luanvan.service;

import com.odkhang.luanvan.model.InfoHotel;

import java.util.List;

public interface IInfoHotelService {
    List<InfoHotel> getAllHotel();

    List<InfoHotel> getLimitHotel();

    InfoHotel getOneHotel(Long idHouse, Long idLocation);
}
