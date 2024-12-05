package com.aysavs.libraryApp.domain.aggragate.member;

import jakarta.persistence.*;
import lombok.*;

@Table(name="members")
@Data
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity

public class Member {
    @Id
    @Column(name="id")  @GeneratedValue(strategy = GenerationType.IDENTITY)private long id;
    @Column(name="name")private String name;
    @Column(name="surname")private String surname;
    @Column(name="gsmNumber") private long gsmNumber;
    @Column(name="mailAddress") private String mailAddress;
    @Column(name="job") private String job;
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private MemberStatus status;
}
