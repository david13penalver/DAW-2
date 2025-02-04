package com.fpmislata.bookstore.persistence.dao.db.jpa;

import com.fpmislata.bookstore.domain.model.Figure;
import com.fpmislata.bookstore.domain.model.ListWithCount;
import com.fpmislata.bookstore.persistence.dao.db.FigureDaoDb;
import com.fpmislata.bookstore.persistence.dao.db.jpa.mapper.FigureJPAMapper;
import com.fpmislata.bookstore.persistence.dao.db.jpa.repository.FigureJPARepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class FigureDaoDbImpl implements FigureDaoDb {

    private final FigureJPARepository figureJPARepository;

    @Override
    public List<Figure> getAll() {
        return List.of();
    }

    @Override
    public ListWithCount<Figure> getAll(int page, int size) {
        return null;
    }

    @Override
    public Optional<Figure> findById(long id) {
        return Optional.empty();
    }

    @Override
    public long insert(Figure figure) {
        return 0;
    }

    @Override
    public void update(Figure figure) {

    }

    @Override
    public void delete(long id) {

    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public Figure save(Figure figure) {
        return null;
    }

    @Override
    public List<Figure> findAllById(Long[] ids) {
        return figureJPARepository
                .findAllById(List.of(ids))
                .stream()
                .map(FigureJPAMapper.INSTANCE::toFigure)
                .toList();
    }
}
