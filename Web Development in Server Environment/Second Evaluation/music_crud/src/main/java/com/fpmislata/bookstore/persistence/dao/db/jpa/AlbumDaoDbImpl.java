package com.fpmislata.bookstore.persistence.dao.db.jpa;

import com.fpmislata.bookstore.domain.model.Album;
import com.fpmislata.bookstore.domain.model.ListWithCount;
import com.fpmislata.bookstore.persistence.dao.db.AlbumDaoDb;
import com.fpmislata.bookstore.persistence.dao.db.jpa.entity.AlbumJPA;
import com.fpmislata.bookstore.persistence.dao.db.jpa.mapper.AlbumJPAMapper;
import com.fpmislata.bookstore.persistence.dao.db.jpa.repository.AlbumJPARepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class AlbumDaoDbImpl implements AlbumDaoDb {

    private final AlbumJPARepository albumJPARepository;

    @Override
    public List<Album> getAll() {
        return List.of();
    }

    @Override
    public ListWithCount<Album> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<AlbumJPA> albumPage = albumJPARepository.findAll(pageable);
        return new ListWithCount<>(
                albumPage.stream()
                        .map(AlbumJPAMapper.INSTANCE::toAlbum)
                        .toList(),
                albumPage.getTotalElements()
        );
    }

    @Override
    public Optional<Album> findById(long id) {
        return Optional.empty();
    }

    @Override
    public long insert(Album album) {
        return 0;
    }

    @Override
    public void update(Album album) {

    }

    @Override
    public void delete(long id) {

    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public Album save(Album album) {
        return null;
    }
}
