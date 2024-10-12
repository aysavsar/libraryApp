package com.aysavs.libraryApp.aplication.controller;

import com.aysavs.libraryApp.aplication.service.BookService;
import com.aysavs.libraryApp.aplication.service.request.CreateBookRequest;
import com.aysavs.libraryApp.aplication.service.request.book.UpdateBookRequest;
import com.aysavs.libraryApp.domain.aggragate.book.Book;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
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

    @PutMapping("{bookId}/update")
    public ResponseEntity<Long> update(@PathVariable Long bookId, @RequestBody UpdateBookRequest updateBookRequest) {
        updateBookRequest.setBookId(bookId);
        long updatedBookId = bookService.update(updateBookRequest);
        return ResponseEntity.ok(updatedBookId);
    }
}
