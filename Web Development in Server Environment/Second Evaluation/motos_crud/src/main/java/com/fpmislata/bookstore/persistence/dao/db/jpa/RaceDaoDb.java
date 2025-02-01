package com.fpmislata.bookstore.persistence.dao.db.jpa;

import com.fpmislata.bookstore.domain.model.ListWithCount;
import com.fpmislata.bookstore.domain.model.Race;
import com.fpmislata.bookstore.persistence.dao.db.RaceDao;
import com.fpmislata.bookstore.persistence.dao.db.jpa.entity.RaceJPA;
import com.fpmislata.bookstore.persistence.dao.db.jpa.mapper.RaceJPAMapper;
import com.fpmislata.bookstore.persistence.dao.db.jpa.repository.RaceJPARepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class RaceDaoDb implements RaceDao {

    private final RaceJPARepository raceJPARepository;

    @Override
    public List<Race> getAll() {
        return List.of();
    }

    @Override
    public ListWithCount<Race> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<RaceJPA> raceJPAPage = raceJPARepository.findAll(pageable);
        return new ListWithCount<Race>(
                raceJPAPage.stream()
                        .map(RaceJPAMapper.INSTANCE::toRace)
                        .toList(),
                raceJPAPage.getTotalElements()
        );
    }

    @Override
    public Optional<Race> findById(long id) {
        return raceJPARepository.findById(id).map(RaceJPAMapper.INSTANCE::toRace);
    }

    @Override
    public long insert(Race race) {
        RaceJPA raceJPA = RaceJPAMapper.INSTANCE.toRaceJPA(race);
        return raceJPARepository.save(raceJPA).getId();
    }

    @Override
    public void update(Race race) {

    }

    @Override
    public void delete(long id) {
        raceJPARepository.deleteById(id);
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public Race save(Race race) {
        return null;
    }
}
