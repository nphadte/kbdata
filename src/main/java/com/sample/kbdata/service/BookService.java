package com.sample.kbdata.service;

import com.sample.kbdata.model.Book;
import com.sample.kbdata.repository.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private BookRepository  bookRepository;

    public  void save(Book book){
        this.bookRepository.save(book);
    }
}
