package com.aysavs.libraryApp.aplication.controller;

import com.aysavs.libraryApp.aplication.service.LiberianService;
import com.aysavs.libraryApp.domain.aggragate.liberian.Liberian;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
