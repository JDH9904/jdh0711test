package com.korea.book;
import java.time.LocalDateTime;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(length = 200)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String author;

    private LocalDateTime createDate;

    @ManyToOne
    private bookstore bookstore;
}
