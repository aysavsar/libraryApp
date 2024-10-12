package com.aysavs.libraryApp.aplication.service.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
public class CreateLoanRequest {

    private long bookId;

    private long memberId;

    private long liberianId;

    @NotBlank
    private String loanStatus;

    @NotBlank
    private String race;

    private Date loanDate;
    private Date refundDate;

    private int remainingRight;

    private int loanedBookCount;

    private boolean isForbidden;
}
