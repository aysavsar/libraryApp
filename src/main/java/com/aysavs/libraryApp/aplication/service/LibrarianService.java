package com.aysavs.libraryApp.aplication.service;

import com.aysavs.libraryApp.aplication.service.converter.LibrarianRequestConverter;
import com.aysavs.libraryApp.aplication.service.request.librarian.CreateLibrarianRequest;
import com.aysavs.libraryApp.aplication.service.request.librarian.UpdateLibrarianRequest;
import com.aysavs.libraryApp.aplication.service.validator.CreateLibrarianRequestValidator;
import com.aysavs.libraryApp.domain.aggragate.librarian.Librarian;
import com.aysavs.libraryApp.domain.aggragate.librarian.LibrarianStatus;
import com.aysavs.libraryApp.infrastructure.repository.LibrarianRepository;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class LibrarianService {

    private final LibrarianRepository librarianRepository;
    private final CreateLibrarianRequestValidator createLibrarianRequestValidator;
    private final LibrarianRequestConverter librarianRequestConverter;

    public LibrarianService(LibrarianRepository librarianRepository,
                            CreateLibrarianRequestValidator createLibrarianRequestValidator,
                            LibrarianRequestConverter librarianRequestConverter) {
        this.librarianRepository = librarianRepository;
        this.createLibrarianRequestValidator = createLibrarianRequestValidator;
        this.librarianRequestConverter = librarianRequestConverter;
    }

    public List<Librarian> getAll() {
        return librarianRepository.findAll();
    }

    public Long create(CreateLibrarianRequest createLibrarianRequest) {
        createLibrarianRequestValidator.validate(createLibrarianRequest);
        Librarian librarian = librarianRequestConverter.convert(createLibrarianRequest);
        Librarian savedLibrarian = librarianRepository.save(librarian);

        return savedLibrarian.getId();
    }

    public Long update(UpdateLibrarianRequest request, Long librarianId) {
        Librarian librarian = librarianRepository.findById(librarianId)
                .orElseThrow(() -> new NotFoundException("Librarian not found"));

        // İsim, soyisim, mail adresi ve telefon numarasını güncelle
        Optional.ofNullable(request.getName()).ifPresent(librarian::setName);
        Optional.ofNullable(request.getSurname()).ifPresent(librarian::setSurname);
        Optional.ofNullable(request.getMailAddress()).ifPresent(librarian::setMailAddress);
        Optional.ofNullable(request.getGsmNumber()).ifPresent(librarian::setGsmNumber);

        // Durum güncelleme
        Optional.ofNullable(request.getStatus())
                .map(String::toUpperCase)
                .map(LibrarianStatus::valueOf) // Enum değerine dönüştür
                .ifPresent(librarian::setStatus);

        librarianRepository.save(librarian); // Güncellenmiş kütüphaneciyi kaydet

        return librarianId; // Güncellenen kütüphanecinin ID'sini döndür
    }

}
