package com.aysavs.libraryApp.aplication.service.converter;

import com.aysavs.libraryApp.aplication.service.request.librarian.CreateLibrarianRequest;
import com.aysavs.libraryApp.domain.aggragate.librarian.Librarian;
import org.springframework.stereotype.Component;

@Component
public class LibrarianRequestConverter {
    public Librarian convert(CreateLibrarianRequest createLibrarianRequest){
        Librarian librarian = new Librarian();
        librarian.setName(createLibrarianRequest.getName());
        librarian.setSurname(createLibrarianRequest.getSurname());
        librarian.setGsmNumber(createLibrarianRequest.getGsmNumber());
        librarian.setMailAddress(createLibrarianRequest.getMailAddress());
        return librarian;
    }
}