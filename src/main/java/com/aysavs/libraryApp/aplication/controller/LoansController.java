package com.aysavs.libraryApp.aplication.controller;

import com.aysavs.libraryApp.aplication.service.LoanService;
import com.aysavs.libraryApp.domain.aggragate.loan.Loan;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/loans")
public class LoansController {

    private final LoanService loanService;

    @GetMapping
    public List<Loan> getAll() {
        return loanService.getAll(); // AuthorService üzerinden yazarları al
    }
}
