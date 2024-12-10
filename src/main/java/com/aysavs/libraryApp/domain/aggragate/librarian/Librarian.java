package com.aysavs.libraryApp.domain.aggragate.librarian;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "librarians")
@Data
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Librarian {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "gsmNumber")
    private long gsmNumber;

    @Column(name = "mailAddress")
    private String mailAddress;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private LibrarianStatus status = LibrarianStatus.UNKNOWN;

}
