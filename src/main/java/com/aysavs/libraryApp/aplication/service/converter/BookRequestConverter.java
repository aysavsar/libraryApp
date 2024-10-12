package com.aysavs.libraryApp.aplication.service.converter;

import com.aysavs.libraryApp.aplication.service.request.CreateBookRequest;
import com.aysavs.libraryApp.domain.aggragate.book.Book;
import com.aysavs.libraryApp.domain.aggragate.book.BookStatus;
import org.springframework.stereotype.Component;

@Component
public class BookRequestConverter {

    private static final int INITIAL_BOOK_COUNT = 0;


    public Book convert(CreateBookRequest createBookRequest){
        Book book=new Book();
        book.setTitle(createBookRequest.getTitle());
        book.setEditionNumber(createBookRequest.getEditionNumber());
        book.setType(createBookRequest.getType());
        book.setLanguage(createBookRequest.getLanguage());
        book.setAuthorId(createBookRequest.getAuthorId());
        book.setPublicationDate(createBookRequest.getPublicationDate());
        book.setTotalBookCount(INITIAL_BOOK_COUNT);
        book.setBookStatus(BookStatus.AVAILABLE);
        return book;
    }
}
