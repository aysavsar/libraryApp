package com.aysavs.libraryApp.aplication.service.request.loan;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UpdateLoanRequest {
    private Long bookId;
    private Long memberId;
    private Long librarianId;
    private Date loanDate;
    private Date returnDate;
    private int remainingRight;
    private int loanedBookCount;
    private boolean isForbidden;
    private String loanStatus;
}
