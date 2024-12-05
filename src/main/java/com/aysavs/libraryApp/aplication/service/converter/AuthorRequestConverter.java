package com.aysavs.libraryApp.aplication.service.converter;

import com.aysavs.libraryApp.aplication.service.request.author.CreateAuthorRequest;
import com.aysavs.libraryApp.domain.aggragate.author.Author;
import org.springframework.stereotype.Component;

@Component
public class AuthorRequestConverter {

    private static final int INITIAL_WRITTEN_BOOK_COUNT = 0;

    public Author convert(CreateAuthorRequest createAuthorRequest) {
        Author author = new Author();
        author.setName(createAuthorRequest.getName());
        author.setSurname(createAuthorRequest.getSurname());
        author.setRace(createAuthorRequest.getRace());
        author.setGender(createAuthorRequest.getGender());
        author.setBirthDate(createAuthorRequest.getBirthDate());
        author.setDeathDate(createAuthorRequest.getDeathDate());
        author.setWrittenBookCount(INITIAL_WRITTEN_BOOK_COUNT);
        return author;
    }
}
