package com.aysavs.libraryApp.aplication.controller;

import com.aysavs.libraryApp.aplication.service.LiberianService;
import com.aysavs.libraryApp.aplication.service.request.CreateLiberianRequest;
import com.aysavs.libraryApp.domain.aggragate.liberian.Liberian;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/liberians")
public class LiberiansController {

    private final LiberianService liberianService;

    @GetMapping
    public List<Liberian> getAll()
    {
        return liberianService.getAll();
    }

    @PostMapping("/create")
    public ResponseEntity<Long> create(@Valid @RequestBody CreateLiberianRequest createLiberianRequest ){
        Long createdLiberianId=liberianService.create(createLiberianRequest);
        return ResponseEntity.ok(createdLiberianId);
    }

}
