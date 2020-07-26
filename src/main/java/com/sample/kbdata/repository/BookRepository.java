package com.sample.kbdata.repository;

import com.sample.kbdata.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Long>{

    /*
     * select book0_.BOOK_ID as BOOK_ID1_0_, book0_.PAGE_COUNT as
     * PAGE_COU2_0_, book0_.PRICE as PRICE3_0_, book0_.PUBLISH_DATE as
     * PUBLISH_4_0_, book0_.TITLE as TITLE5_0_ from BOOK book0_ where
     * book0_.TITLE=?
     */

    public Book findByTitle(String title);

    public List<Book> findByPublishDateAfter(Date date);

    public List<Book> findByPublishDateBefore(Date date);

    public List<Book> findByPublishDateBetween(Date date,Date date2);

    public List<Book> findTopByOrderByPageCountDesc();

    public List<Book> findFirstByOrderByPageCountAsc();

    public List<Book> findTop5ByOrderByPriceDesc();

    public List<Book> findTop5ByTitleOrderByPriceAsc(String title);

    // Logical Operators
    public List<Book> findByTitleContainingOrTitleContaining(String title, String title2);

    public List<Book> findByTitleContainingAndPageCountGreaterThan(String title, int pageCount);

    public List<Book> findByTitleNot(String title);

    // Ordering results
    public List<Book> findByTitleContainingOrderByTitleAsc(String title);

    public List<Book> findByTitleContainingOrderByTitleDesc(String title);

    // Relational Operators
    public List<Book> findByPageCountEquals(int pageCount);

    public List<Book> findByPageCountLessThan(int pageCount);

    public List<Book> findByPageCountLessThanEqual(int pageCount);

    public List<Book> findByPageCountBetween(int min, int max);

    // String Operators
    public List<Book> findByTitleLike(String title);

    public List<Book> findByTitleContaining(String title);

    public List<Book> findByTitleStartingWith(String title);

    public List<Book> findByTitleEndingWith(String title);

    public List<Book> findByTitleIgnoreCase(String title);

    // Traversing Nested Properties
    public List<Book> findByAuthorFirstName(String firstName);

    public List<Book> findByAuthor_Country(String country);

    // specifying queries
    @Query("select b from Book b")
    public List<Book> queryOne();

    @Query("select b from Book b where b.pageCount > ?1")
    public List<Book> queryTwo(int pageCount);

    @Query("select b from Book b where b.title = :title")
    public List<Book> queryThree(@Param("title") String title);

    // Named query
    public List<Book> queryNOne();

    public List<Book> queryNTwo(int pageCount);

    public List<Book> queryNThree(@Param("title") String title);

    // Paging queries
    public List<Book> findByPageCountGreaterThan(int pageCount, Pageable pageable);

 }
