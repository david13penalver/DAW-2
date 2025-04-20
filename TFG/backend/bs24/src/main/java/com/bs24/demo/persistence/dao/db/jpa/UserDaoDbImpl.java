package com.bs24.demo.persistence.dao.db.jpa;

import com.bs24.demo.domain.model.ListWithCount;
import com.bs24.demo.domain.model.User;
import com.bs24.demo.persistence.dao.db.UserDaoDb;
import com.bs24.demo.persistence.dao.db.jpa.entity.ExerciseJPA;
import com.bs24.demo.persistence.dao.db.jpa.entity.UserJPA;
import com.bs24.demo.persistence.dao.db.jpa.mapper.ExerciseJPAMapper;
import com.bs24.demo.persistence.dao.db.jpa.mapper.UserJPAMapper;
import com.bs24.demo.persistence.dao.db.jpa.repository.UserJPARepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserDaoDbImpl implements UserDaoDb {

    private final UserJPARepository userJPARepository;

    @Override
    public List<User> getAll() {
        return List.of();
    }

    @Override
    public ListWithCount<User> getAll(int page, int size) {
        return null;
    }

    @Override
    public Optional<User> findById(long id) {
        return userJPARepository.findById(id)
                .map(UserJPAMapper.INSTANCE::toUser);
    }

    @Override
    public long insert(User user) {
        return 0;
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(long id) {
        userJPARepository.deleteById(id);
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public User save(User user) {
        UserJPA userJPA = UserJPAMapper.INSTANCE.toUserJPA(user);
        return UserJPAMapper.INSTANCE.toUser(userJPARepository.save(userJPA));
    }
}
