package com.aysavs.libraryApp.aplication.service;


import com.aysavs.libraryApp.domain.aggragate.liberian.Liberian;
import com.aysavs.libraryApp.infrastructure.repository.AuthorRepository;
import com.aysavs.libraryApp.infrastructure.repository.LiberianRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LiberianService {

    private final LiberianRepository liberianRepository;

    public LiberianService(LiberianRepository liberianRepository) {
        this.liberianRepository = liberianRepository;
    }
    public List<Liberian> getAll() {
        return liberianRepository.findAll();

    }
}

