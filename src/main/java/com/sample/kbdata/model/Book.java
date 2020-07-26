package com.sample.kbdata.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor


@Entity
@NamedQueries({@NamedQuery(name = "Book.queryNOne", query = "select b from Book b"),
        @NamedQuery(name = "Book.queryNTwo", query = "select b from Book b where b.pageCount > ?1"),
        @NamedQuery(name = "Book.queryNThree", query = "select b from Book b where b.title = :title")})
@EntityListeners(AuditingEntityListener.class)
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long bookId;

    public String title;

    public Date publishDate;

    public int pageCount;

    public BigDecimal price;

    @ManyToOne
    @JoinColumn(name="AUTHOR_ID")
    private Author author;

    @CreatedBy
    private String createdBy;

    @LastModifiedBy
    private String lastModifiedBy;

    @CreatedDate
    private Date createdDate;

    @LastModifiedDate
    private Date lastModifiedDate;
}
