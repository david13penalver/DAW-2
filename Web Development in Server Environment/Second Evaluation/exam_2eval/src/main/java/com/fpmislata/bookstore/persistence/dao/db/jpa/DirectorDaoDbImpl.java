package com.fpmislata.bookstore.persistence.dao.db.jpa;

import com.fpmislata.bookstore.domain.model.Director;
import com.fpmislata.bookstore.domain.model.ListWithCount;
import com.fpmislata.bookstore.persistence.dao.db.DirectorDaoDb;
import com.fpmislata.bookstore.persistence.dao.db.jpa.mapper.DirectorJPAMapper;
import com.fpmislata.bookstore.persistence.dao.db.jpa.repository.DirectorJPARepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class DirectorDaoDbImpl implements DirectorDaoDb {

    private final DirectorJPARepository directorJPARepository;

    @Override
    public List<Director> getAll() {
        return List.of();
    }

    @Override
    public ListWithCount<Director> getAll(int page, int size) {
        return null;
    }

    @Override
    public Optional<Director> findById(long id) {
        return directorJPARepository.findById(id).map(DirectorJPAMapper.INSTANCE::toDirector);
    }

    @Override
    public long insert(Director director) {
        return 0;
    }

    @Override
    public void update(Director director) {

    }

    @Override
    public void delete(long id) {

    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public Director save(Director director) {
        return null;
    }
}
