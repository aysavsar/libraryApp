package com.aysavs.libraryApp.aplication.controller;

import com.aysavs.libraryApp.aplication.service.LoanService;
import com.aysavs.libraryApp.aplication.service.request.loan.CreateLoanRequest;
import com.aysavs.libraryApp.aplication.service.request.loan.UpdateLoanRequest;
import com.aysavs.libraryApp.domain.aggragate.loan.Loan;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/loans")
public class LoansController {

    private final LoanService loanService;

    @GetMapping
    public List<Loan> getAll() {
        return loanService.getAll();
    }

    //TODO: caner.yesildag: action should be loan for this flow
    @PostMapping("/create")
    public ResponseEntity<Long> create(@Valid @RequestBody CreateLoanRequest createLoanRequest ) {
        Long createdLoanId = loanService.create(createLoanRequest);
        return ResponseEntity.ok(createdLoanId);
    }
    @PutMapping("/{loanId}/update")
    public ResponseEntity<Long> updateLoan(@PathVariable Long loanId,
                                           @RequestBody UpdateLoanRequest request) {
        Long updatedLoanId = loanService.update(request, loanId);
        return ResponseEntity.ok(updatedLoanId);
    }

}
