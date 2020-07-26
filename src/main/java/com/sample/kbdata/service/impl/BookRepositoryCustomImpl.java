package com.sample.kbdata.service.impl;

import com.sample.kbdata.model.Book;
import com.sample.kbdata.repository.BookRepositoryCustom;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

public class BookRepositoryCustomImpl implements BookRepositoryCustom {

    private static Logger logger = LoggerFactory.getLogger(BookRepositoryCustomImpl.class);

    @Autowired
    private EntityManager entityManager;

    @Override
    @Transactional
    public void saveAndLog(Book book) {
        logger.debug("Saving the book entity" + book.toString());
        entityManager.persist(book);
    }

}
