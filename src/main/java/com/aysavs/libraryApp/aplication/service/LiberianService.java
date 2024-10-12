package com.aysavs.libraryApp.aplication.service;


import com.aysavs.libraryApp.aplication.service.converter.LiberianRequestConverter;
import com.aysavs.libraryApp.aplication.service.request.CreateLiberianRequest;
import com.aysavs.libraryApp.aplication.service.validator.CreateLiberianRequestValidator;
import com.aysavs.libraryApp.domain.aggragate.liberian.Liberian;
import com.aysavs.libraryApp.infrastructure.repository.LiberianRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LiberianService {

    private final LiberianRepository liberianRepository;
    private final CreateLiberianRequestValidator createLiberianRequestValidator;;
    private final LiberianRequestConverter liberianRequestConverter;

    public LiberianService(LiberianRepository liberianRepository,
                           CreateLiberianRequestValidator createLiberianRequestValidator,
                           LiberianRequestConverter liberianRequestConverter) {
        this.liberianRepository = liberianRepository;
        this.createLiberianRequestValidator=createLiberianRequestValidator;
        this.liberianRequestConverter=liberianRequestConverter;

    }
    public List<Liberian> getAll() {
        return liberianRepository.findAll();

    }
    public Long create(CreateLiberianRequest createLiberianRequest ) {
        createLiberianRequestValidator.validate(createLiberianRequest);
        Liberian liberian = liberianRequestConverter.convert(createLiberianRequest);
        Liberian savedLiberian = liberianRepository.save(liberian);

        return savedLiberian.getId();
    }
}

