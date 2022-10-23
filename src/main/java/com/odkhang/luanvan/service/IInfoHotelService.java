package com.odkhang.luanvan.service;

import com.odkhang.luanvan.model.InfoHotel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IInfoHotelService {
    InfoHotel getOneHotel(Long idHouse, Long idLocation);

    Page<InfoHotel> allHotels(Pageable p);
}
