package com.aysavs.libraryApp.aplication.service;


import com.aysavs.libraryApp.aplication.service.converter.BookRequestConverter;
import com.aysavs.libraryApp.aplication.service.request.CreateBookRequest;
import com.aysavs.libraryApp.aplication.service.request.book.UpdateBookRequest;
import com.aysavs.libraryApp.aplication.service.validator.CreateBookRequestValidator;
import com.aysavs.libraryApp.domain.aggragate.book.Book;
import com.aysavs.libraryApp.domain.aggragate.book.BookStatus;
import com.aysavs.libraryApp.infrastructure.repository.BookRepository;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

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

    public long update(UpdateBookRequest updateBookRequest) {
        long bookId = updateBookRequest.getBookId();
        Book retrievedBook = bookRepository.findById(bookId)
                .orElseThrow(() -> new NotFoundException("Book not found"));

        Optional.ofNullable(updateBookRequest.getTitle()).ifPresent(retrievedBook::setTitle);
        Optional.ofNullable(updateBookRequest.getType()).ifPresent(retrievedBook::setType);
        Optional.ofNullable(updateBookRequest.getLanguage()).ifPresent(retrievedBook::setLanguage);
        Optional.ofNullable(updateBookRequest.getPublicationDate()).ifPresent(retrievedBook::setPublicationDate);
        Optional.ofNullable(updateBookRequest.getPublishingHouse()).ifPresent(retrievedBook::setPublishingHouse);
        Optional.ofNullable(updateBookRequest.getTotalBookCount()).ifPresent(retrievedBook::setTotalBookCount);

        if (Objects.nonNull(updateBookRequest.getBookStatus())) {
            BookStatus bookStatus = BookStatus.valueOf(updateBookRequest.getBookStatus());
            retrievedBook.setBookStatus(bookStatus);
        }

        Optional.of(updateBookRequest.getEditionNumber())
                .filter(editionNumber -> editionNumber > 0)
                .ifPresent(retrievedBook::setEditionNumber);

        Optional.of(updateBookRequest.getAuthorId())
                .filter(authorId -> authorId > 0)
                .ifPresent(retrievedBook::setAuthorId);

        bookRepository.updateBookById(bookId, retrievedBook);

        return bookId;

    }
}
