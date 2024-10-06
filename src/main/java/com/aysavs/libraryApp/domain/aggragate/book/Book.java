package com.aysavs.libraryApp.domain.aggragate.book;

import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Table(name="books")
@Data
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity

public class Book {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) private int id;
    @Column(name="titile") private String titile;
    @Column(name="type") private String type;
    @Column (name="language")private String language;
    @Column (name="editionNumber")private int editionNumber;
    @Column (name="authorId")private long authorId;
    @Column(name="publicationDate") private Date publicationDate;
    @Column (name="publishingHouse")private String publishingHouse;
    @Column(name="totalBookCount") private int totalBookCount;

}
