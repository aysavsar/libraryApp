package com.aysavs.libraryApp.aplication.service.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CreateAuthorRequest {

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

    @JsonIgnore
    private int writtenBookCount;
}
