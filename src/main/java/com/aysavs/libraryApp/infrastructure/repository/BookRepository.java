package com.aysavs.libraryApp.infrastructure.repository;

import com.aysavs.libraryApp.domain.aggragate.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

   // void updateBookById(long id, Book book); // update book from Book where id = 262
}
