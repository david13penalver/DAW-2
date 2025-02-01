package com.fpmislata.bookstore.persistence.dao.db.jpa;

import com.fpmislata.bookstore.domain.model.Bike;
import com.fpmislata.bookstore.domain.model.ListWithCount;
import com.fpmislata.bookstore.persistence.dao.db.BikeDao;

import java.util.List;
import java.util.Optional;

public class BikeDaoDb implements BikeDao {
    @Override
    public List<Bike> getAll() {
        return List.of();
    }

    @Override
    public ListWithCount<Bike> getAll(int page, int size) {
        return null;
    }

    @Override
    public Optional<Bike> findById(long id) {
        return Optional.empty();
    }

    @Override
    public long insert(Bike bike) {
        return 0;
    }

    @Override
    public void update(Bike bike) {

    }

    @Override
    public void delete(long id) {

    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public Bike save(Bike bike) {
        return null;
    }
}
