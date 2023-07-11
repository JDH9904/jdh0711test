package com.korea.book;
import java.time.LocalDateTime;

import jakarta.persistence.*;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class bookstore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 200)
    private String store;





    @OneToMany(mappedBy = "bookstore", cascade = CascadeType.REMOVE)
    private List<book> bookList;
}
