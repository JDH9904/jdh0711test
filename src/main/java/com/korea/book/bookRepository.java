package com.korea.book;
import org.springframework.data.jpa.repository.JpaRepository;
public interface bookRepository extends JpaRepository<book,Integer> {
    book findByAuthor(String author);
}
