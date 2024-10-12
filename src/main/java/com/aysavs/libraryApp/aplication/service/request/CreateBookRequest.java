package com.aysavs.libraryApp.aplication.service.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter

public class CreateBookRequest {
    @NotBlank
    private String title;

    @NotBlank
    private String type;

    @NotBlank
    private String language;

    @Min(value = 0, message = "edition number must be greater than 0")
    private int editionNumber;

    private long authorId;


    private Date publicationDate;

    @NotBlank
    private String publishingHouse;

}