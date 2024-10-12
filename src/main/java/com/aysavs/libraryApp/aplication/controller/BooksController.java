package com.aysavs.libraryApp.aplication.controller;

import com.aysavs.libraryApp.aplication.service.BookService;
import com.aysavs.libraryApp.aplication.service.request.CreateBookRequest;
import com.aysavs.libraryApp.domain.aggragate.book.Book;
import jakarta.validation.Valid;
import jakarta.websocket.Endpoint;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/books")
public class BooksController {

    private final BookService bookService;

    @GetMapping
    public List<Book> getAll() {
        return bookService.getAll();
    }

    @PostMapping("/create")
    public ResponseEntity<Long> create(@Valid @RequestBody CreateBookRequest createBookRequest){
        Long createdBookId=bookService.create(createBookRequest);
        return ResponseEntity.ok(createdBookId);
    }
}
