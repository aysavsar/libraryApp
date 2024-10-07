package com.aysavs.libraryApp.aplication.service;

import com.aysavs.libraryApp.aplication.service.converter.AuthorRequestConverter;
import com.aysavs.libraryApp.aplication.service.request.CreateAuthorRequest;
import com.aysavs.libraryApp.aplication.service.validator.CreateAuthorRequestValidator;
import com.aysavs.libraryApp.domain.aggragate.author.Author;
import com.aysavs.libraryApp.infrastructure.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;
    private final CreateAuthorRequestValidator createAuthorRequestValidator;
    private final AuthorRequestConverter authorRequestConverter;

    public AuthorService(AuthorRepository authorRepository,
                         CreateAuthorRequestValidator createAuthorRequestValidator,
                         AuthorRequestConverter authorRequestConverter) {
        this.authorRepository = authorRepository;
        this.createAuthorRequestValidator = createAuthorRequestValidator;
        this.authorRequestConverter = authorRequestConverter;
    }

    public List<Author> getAll() {
        return authorRepository.findAll();
    }

    public Long create(CreateAuthorRequest createAuthorRequest) {
        createAuthorRequestValidator.validate(createAuthorRequest);
        Author author = authorRequestConverter.convert(createAuthorRequest);
        // Bir yazar daha önce kaydedilmiş mi kontrolü yapalım
        Author savedAuthor = authorRepository.save(author);

        return savedAuthor.getId();
    }
}
