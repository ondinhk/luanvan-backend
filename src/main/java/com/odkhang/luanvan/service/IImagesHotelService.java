package com.odkhang.luanvan.service;


import com.odkhang.luanvan.model.imagesHotel;

import java.util.List;

public interface IImagesHotelService {
    List<imagesHotel> getImageById(Long idHouse);
}
