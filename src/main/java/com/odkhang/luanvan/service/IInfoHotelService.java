package com.odkhang.luanvan.service;

import com.odkhang.luanvan.model.InfoHotel;

public interface IInfoHotelService {
    InfoHotel getOneHotel(Long idHouse, Long idLocation);
}
