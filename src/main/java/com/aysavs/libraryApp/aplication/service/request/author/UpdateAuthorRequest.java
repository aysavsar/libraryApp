package com.aysavs.libraryApp.aplication.service.request.author;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UpdateAuthorRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String surname;

    @NotBlank
    private String gender;

    @NotBlank
    private String race;

    private LocalDate birthDate;
    private LocalDate deathDate;

    private String status;

    @JsonIgnore
    private int writtenBookCount;


}
