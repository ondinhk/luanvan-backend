package com.odkhang.luanvan.repository;

import com.odkhang.luanvan.model.InfoHotel;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import java.util.List;
public interface IInfoHotelPageRepository extends PagingAndSortingRepository<InfoHotel, String> {
    List<InfoHotel> findAllById(Pageable pageable);

}
