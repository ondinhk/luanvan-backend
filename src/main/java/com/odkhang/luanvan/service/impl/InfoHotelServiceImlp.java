package com.odkhang.luanvan.service.impl;

import com.odkhang.luanvan.model.InfoHotel;
import com.odkhang.luanvan.repository.IInfoHotelRepository;
import com.odkhang.luanvan.service.IInfoHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

@Service
public class InfoHotelServiceImlp implements IInfoHotelService {
    @Autowired
    IInfoHotelRepository infoHotelRepo;

    @Override
    public InfoHotel getHotel(String idHotel) {
        return infoHotelRepo.findHotelById(idHotel);
    }

    @Override
    public Page<InfoHotel> getAllHotels(Pageable p) {
        return infoHotelRepo.findAll(p);
    }

    @Override
    public Page<InfoHotel> findAllByIdLocation(int idLocation, Pageable p) {
        return infoHotelRepo.findByIdLocation(idLocation, p);
    }

    @Override
    public List<InfoHotel> recommendHotelsMachine(String input, String size, String idLocation) {
        String[] listIdHotel = getListIdHotelFromMachine(input, size, idLocation);
        List<InfoHotel> listHotels = new ArrayList<InfoHotel>();
        for (String id : listIdHotel) {
            InfoHotel tmpHotels = infoHotelRepo.findHotelById(id);
            listHotels.add(tmpHotels);
        }
        listHotels.sort(new Comparator<InfoHotel>() {
            @Override
            public int compare(InfoHotel o1, InfoHotel o2) {
                return o2.getNumber_reviews() - o1.getNumber_reviews();
            }
        });
        return listHotels;
    }

    @Override
    public Long countNumberHotelInLocation(Long idLocation) {
        return infoHotelRepo.countNumberHotelInLocation(idLocation);
    }

    private String[] getListIdHotelFromMachine(String input, String size, String idLocation) {
//        String url = "http://python-machine:5000/recommend";
        String url = "http://0.0.0.0:5000/recommend";
        try {
            URI uri = new URI(url);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("input", input);
        map.add("size", size);
        map.add("idLocation", idLocation);
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);

        ResponseEntity<String[]> response = restTemplate.postForEntity(url, request, String[].class);
        return response.getBody();
    }
}
