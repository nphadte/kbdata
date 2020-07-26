package com.sample.kbdata.repository;

import com.sample.kbdata.model.Author;
import com.sample.kbdata.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.cdi.JpaRepositoryExtension;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author,Long> {


}
