package com.aysavs.libraryApp.aplication.controller;

import com.aysavs.libraryApp.aplication.service.AuthorService;
import com.aysavs.libraryApp.aplication.service.request.author.CreateAuthorRequest;
import com.aysavs.libraryApp.aplication.service.request.author.UpdateAuthorRequest;
import com.aysavs.libraryApp.domain.aggragate.author.Author;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/create")
    public ResponseEntity<Long> create(@Valid @RequestBody CreateAuthorRequest createAuthorRequest) {
        Long createdAuthorId = authorService.create(createAuthorRequest);
        return ResponseEntity.ok(createdAuthorId);
    }
    @PutMapping("/{authorId}/update")
    public ResponseEntity<Long> updateAuthor(@PathVariable Long authorId,
                                             @Valid @RequestBody UpdateAuthorRequest request) {
        Long updatedAuthorId = authorService.update(request, authorId);
        return ResponseEntity.ok(updatedAuthorId);
    }
}
