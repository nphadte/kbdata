package com.sample.kbdata.repository;

import com.sample.kbdata.model.Book;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepositoryCustom {

    public void saveAndLog(Book book);
}
