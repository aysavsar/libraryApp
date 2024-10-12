package com.aysavs.libraryApp.domain.aggragate.liberian;

import jakarta.persistence.*;
import lombok.*;

@Table(name="liberians")
@Data
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity

public class Liberian {
    @Id
    @Column(name="id")  @GeneratedValue(strategy = GenerationType.IDENTITY)private long id;
    @Column(name="name")private String name;
    @Column(name="surname")private String surname;
    @Column(name="gsmNumber")private long gsmNumber;
    @Column(name="mailAddress")private String mailAddress;


}
