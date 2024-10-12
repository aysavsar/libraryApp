package com.aysavs.libraryApp.aplication.service.request.book;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UpdateBookRequest {

    private String title;
    private String type;
    private String language;
    private String bookStatus;
    private int editionNumber;
    private long authorId;
    private Date publicationDate;
    private String publishingHouse;
    private Integer totalBookCount;

    @JsonIgnore
    private long bookId;
}
