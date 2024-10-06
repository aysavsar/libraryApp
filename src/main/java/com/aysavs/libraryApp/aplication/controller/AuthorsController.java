package com.aysavs.libraryApp.aplication.controller;

import com.aysavs.libraryApp.aplication.service.AuthorService;
import com.aysavs.libraryApp.domain.aggragate.author.Author;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor//genellikle bu kullanılır  nedenlefri
@RestController
@RequestMapping("/api/authors")
public class AuthorsController {

    private  final AuthorService authorService;

    @GetMapping
    public List<Author> getAll() {
        return authorService.getAll(); // AuthorService üzerinden yazarları al
    }


}
