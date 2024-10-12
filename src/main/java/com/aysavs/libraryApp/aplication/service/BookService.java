package com.aysavs.libraryApp.aplication.service;


import com.aysavs.libraryApp.aplication.service.converter.BookRequestConverter;
import com.aysavs.libraryApp.aplication.service.request.CreateBookRequest;
import com.aysavs.libraryApp.aplication.service.validator.CreateBookRequestValidator;
import com.aysavs.libraryApp.domain.aggragate.book.Book;
import com.aysavs.libraryApp.infrastructure.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final CreateBookRequestValidator createBookRequestValidator;
    private  final BookRequestConverter bookRequestConverter;


    public BookService(BookRepository bookRepository,
                       CreateBookRequestValidator createBookRequestValidator,
                       BookRequestConverter bookRequestConverter) {

        this.bookRepository = bookRepository;
        this.createBookRequestValidator=createBookRequestValidator;
        this.bookRequestConverter =bookRequestConverter;
    }

    public List<Book> getAll() {
        return bookRepository.findAll(); // BookRepository üzerinden kitapları al
    }

    public Long create(CreateBookRequest createBookRequest){
        createBookRequestValidator.validate(createBookRequest);
        Book book=bookRequestConverter.convert(createBookRequest);
        Book savedBook =bookRepository.save(book);

        return(long)savedBook.getId();
    }

}
