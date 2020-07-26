package com.sample.kbdata.repository;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.io.Serializable;

@NoRepositoryBean
public interface ReadOnlyRepository<T,ID extends Serializable> extends Repository<T, ID> {

    T findOne(ID id);
    Iterable<T> findAll();
}
