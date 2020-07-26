package com.sample.kbdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.scheduling.annotation.Async;

import java.io.Serializable;
import java.util.List;

@NoRepositoryBean
@SuppressWarnings("unchecked")
public interface BaseRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {

    @Async
    public List<T> findByIds(ID...ids);
}