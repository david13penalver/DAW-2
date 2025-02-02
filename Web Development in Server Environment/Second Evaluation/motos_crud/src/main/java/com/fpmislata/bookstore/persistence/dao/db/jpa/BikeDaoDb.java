package com.fpmislata.bookstore.persistence.dao.db.jpa;

import com.fpmislata.bookstore.domain.model.Bike;
import com.fpmislata.bookstore.domain.model.ListWithCount;
import com.fpmislata.bookstore.persistence.dao.db.BikeDao;
import com.fpmislata.bookstore.persistence.dao.db.jpa.entity.BikeJPA;
import com.fpmislata.bookstore.persistence.dao.db.jpa.mapper.BikeJPAMapper;
import com.fpmislata.bookstore.persistence.dao.db.jpa.repository.BikeJPARepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class BikeDaoDb implements BikeDao {

    private final BikeJPARepository bikeJPARepository;

    @Override
    public List<Bike> getAll() {
        return List.of();
    }

    @Override
    public ListWithCount<Bike> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<BikeJPA> bikeJPAPage = bikeJPARepository.findAll(pageable);
        return new ListWithCount<Bike>(
                bikeJPAPage.stream()
                        .map(BikeJPAMapper.INSTANCE::toBike)
                        .toList(),
                bikeJPAPage.getTotalElements()
        );
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
