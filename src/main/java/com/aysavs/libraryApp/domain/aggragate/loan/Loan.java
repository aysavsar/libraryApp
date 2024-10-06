package com.aysavs.libraryApp.domain.aggragate.loan;

import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Table(name="loans")
@Data
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity

public class Loan {
    @Id
    @Column(name="id")  @GeneratedValue(strategy = GenerationType.IDENTITY)private long id;
    @Column(name="bookId") private long bookId;
    @Column(name="memberId")private long memberId;
    @Column(name="loanStatus") private String loanStatus;
    @Column(name="loanDate") private Date loanDate;
    @Column(name="refundDate") private Date refundDate;
    @Column(name="remainingRight")private int remainingRight;
    @Column(name="loanedBookCount")private int loanedBookCount;
    @Column(name="isForbidden")private boolean isForbidden;
    @Column(name="librarianId")private long librarianId;

}
