package com.aysavs.libraryApp.aplication.service;


import com.aysavs.libraryApp.domain.aggragate.book.Book;
import com.aysavs.libraryApp.infrastructure.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAll() {
        return bookRepository.findAll(); // BookRepository üzerinden kitapları al
    }



}
