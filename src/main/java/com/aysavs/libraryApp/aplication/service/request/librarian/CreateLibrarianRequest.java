package com.aysavs.libraryApp.aplication.service.request.librarian;

import com.aysavs.libraryApp.domain.aggragate.librarian.LibrarianStatus;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateLibrarianRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String surname;

    @NotBlank
    private String mailAddress;

    private LibrarianStatus status;

    private long gsmNumber;
}
