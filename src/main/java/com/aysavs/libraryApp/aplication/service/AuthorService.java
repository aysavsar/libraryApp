package com.aysavs.libraryApp.aplication.service;

import com.aysavs.libraryApp.infrastructure.repository.AuthorRepository;
import com.aysavs.libraryApp.domain.aggragate.author.Author;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AuthorService {

    private  final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> getAll() {
        return authorRepository.findAll();
    }

}
