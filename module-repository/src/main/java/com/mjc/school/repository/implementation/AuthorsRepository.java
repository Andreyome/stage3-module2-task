package com.mjc.school.repository.implementation;

import com.mjc.school.repository.BaseRepository;
import com.mjc.school.repository.aspects.OnDelete;
import com.mjc.school.repository.data.DataSource;
import com.mjc.school.repository.model.impl.AuthorModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AuthorsRepository implements BaseRepository<AuthorModel, Long> {

    private final DataSource dataSource;

    @Autowired
    public AuthorsRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<AuthorModel> readAll() {
        return dataSource.getAuthorsModels();
    }

    @Override
    public Optional<AuthorModel> readById(Long id) {
        return Optional.ofNullable(dataSource.getAuthorsModels().get(id.intValue() - 1));
    }

    @Override
    public AuthorModel create(AuthorModel entity) {
        this.dataSource.getAuthorsModels().add(entity);
        return entity;
    }

    @Override
    public AuthorModel update(AuthorModel entity) {
        this.dataSource.getAuthorsModels().set(entity.getId().intValue() - 1, entity);
        return entity;
    }

    @Override
    @OnDelete
    public boolean deleteById(Long id) {
        return dataSource.getAuthorsModels().remove(dataSource.getAuthorsModels().get(id.intValue()));
    }

    @Override
    public boolean existById(Long id) {
        return dataSource.getAuthorsModels().get(id.intValue()) != null;
    }
}
