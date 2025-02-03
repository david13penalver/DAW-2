package com.fpmislata.bookstore.persistence.repository.impl;


import com.fpmislata.bookstore.domain.model.Bike;
import com.fpmislata.bookstore.domain.model.ListWithCount;
import com.fpmislata.bookstore.domain.repository.BikeRepository;
import com.fpmislata.bookstore.persistence.dao.db.BikeDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class BikeRepositoryImpl implements BikeRepository {

    private final BikeDao bikeDao;

    @Override
    public ListWithCount<Bike> getAll(int page, int pageSize) {
        return bikeDao.getAll(page, pageSize);
    }
}
