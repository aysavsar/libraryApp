package com.aysavs.libraryApp.aplication.service.request.loan;

import com.aysavs.libraryApp.domain.aggragate.loan.LoanStatus;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CreateLoanRequest {

    private long bookId;

    private long memberId;

    private long liberianId;

    @NotBlank
    private String race;

    private Date loanDate;
    private Date returnDate;

    private int remainingRight;

    private int loanedBookCount;

    private LoanStatus status;

    private boolean isForbidden;
}
