package com.aysavs.libraryApp.aplication.service.request.librarian;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateLibrarianRequest {
    @NotBlank
    private String name;

    @NotBlank
    private String surname;

    @NotBlank
    private String mailAddress;

    private long gsmNumber;
    private String status;
}
