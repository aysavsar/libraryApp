package com.aysavs.libraryApp.aplication.controller;

import com.aysavs.libraryApp.aplication.service.LibrarianService;
import com.aysavs.libraryApp.aplication.service.request.librarian.CreateLibrarianRequest;
import com.aysavs.libraryApp.aplication.service.request.librarian.UpdateLibrarianRequest;
import com.aysavs.libraryApp.domain.aggragate.librarian.Librarian;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/librarians")
public class LibrariansController {

    private final LibrarianService librarianService;

    @GetMapping
    public List<Librarian> getAll() {
        return librarianService.getAll();
    }

    @PostMapping("/create")
    public ResponseEntity<Long> create(@Valid @RequestBody CreateLibrarianRequest createLibrarianRequest) {
        Long createdLibrarianId = librarianService.create(createLibrarianRequest);
        return ResponseEntity.ok(createdLibrarianId);
    }
    @PutMapping("/{librarianId}/update")
    public ResponseEntity<Long> updateLibrarian(@PathVariable Long librarianId,
                                                @RequestBody UpdateLibrarianRequest request) {
        Long updatedLibrarianId = librarianService.update(request, librarianId);
        return ResponseEntity.ok(updatedLibrarianId);
    }
    @DeleteMapping("/{librarianId}/delete")
    public ResponseEntity<Void> deleteLibrarian(@PathVariable Long librarianId) {
        librarianService.delete(librarianId);
        return ResponseEntity.noContent().build();
    }
}
