package com.aysavs.libraryApp.domain.aggragate.author;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Table(name="authors")
@Data
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Author {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="name")
    private String name;

    @Column(name="surname")
    private String surname;

    @Column(name="writtenBookCount")
    private int writtenBookCount;

    @Column(name="gender")
    private String gender;

    @Column(name="race")
    private String race;

    @Column(name="birthDate")
    private LocalDate birthDate;

    @Column(name="deathDate")
    private LocalDate deathDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = true)
    private AuthorStatus status; // Yazarın durumu
}
