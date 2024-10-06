package com.aysavs.libraryApp.aplication.controller;

import com.aysavs.libraryApp.aplication.service.BookService;
import com.aysavs.libraryApp.domain.aggragate.book.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/books")
public class BooksController {

    private final BookService bookService;

    @GetMapping
    public List<Book> getAll() {

        return bookService.getAll(); // AuthorService üzerinden yazarları al
    }
}
