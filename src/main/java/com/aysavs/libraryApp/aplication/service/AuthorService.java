package com.aysavs.libraryApp.aplication.service;

import com.aysavs.libraryApp.aplication.service.converter.AuthorRequestConverter;
import com.aysavs.libraryApp.aplication.service.request.author.CreateAuthorRequest;
import com.aysavs.libraryApp.aplication.service.request.author.UpdateAuthorRequest;
import com.aysavs.libraryApp.aplication.service.validator.CreateAuthorRequestValidator;
import com.aysavs.libraryApp.domain.aggragate.author.Author;
import com.aysavs.libraryApp.domain.aggragate.author.AuthorStatus;
import com.aysavs.libraryApp.infrastructure.repository.AuthorRepository;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Optional;

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

    public Long update(UpdateAuthorRequest request, Long authorId) {
        // Yazar kaydını bul
        Author author = authorRepository.findById(authorId)
                .orElseThrow(() -> new NotFoundException("Author not found"));

        // İstekten gelen verileri uygula
        Optional.ofNullable(request.getName()).ifPresent(author::setName);
        Optional.ofNullable(request.getSurname()).ifPresent(author::setSurname);
        Optional.ofNullable(request.getGender()).ifPresent(author::setGender);
        Optional.ofNullable(request.getRace()).ifPresent(author::setRace);
        Optional.ofNullable(request.getBirthDate()).ifPresent(author::setBirthDate);
        Optional.ofNullable(request.getDeathDate()).ifPresent(author::setDeathDate);

        // Enum değerini kontrol ederek güncelle
        Optional.ofNullable(request.getStatus())
                .map(String::toUpperCase)
                .map(AuthorStatus::valueOf)
                .ifPresent(author::setStatus);

        if (request.getWrittenBookCount() >= 0) {
            author.setWrittenBookCount(request.getWrittenBookCount());

            authorRepository.save(author);
        }

        // Değişiklikleri kaydet
        authorRepository.save(author);

        return authorId; // Güncellenen yazarın ID'sini döndür
    }
    public void delete(Long authorId) {
        if (!authorRepository.existsById(authorId)) {
            throw new NotFoundException("Author with id " + authorId + " not found");
        }
        authorRepository.deleteById(authorId);
    }
}