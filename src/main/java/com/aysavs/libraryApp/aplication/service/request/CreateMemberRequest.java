package com.aysavs.libraryApp.aplication.service.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class CreateMemberRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String surname;

    @NotBlank
    private String mailAddress;

    @NotBlank
    private String job;

    private long gsmNumber;



}
