package com.aysavs.libraryApp.aplication.service;

import com.aysavs.libraryApp.domain.aggragate.loan.Loan;
import com.aysavs.libraryApp.infrastructure.repository.AuthorRepository;
import com.aysavs.libraryApp.infrastructure.repository.LoanRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LoanService {

    private final LoanRepository loanRepository;

    public LoanService(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    public List<Loan> getAll() {
        return loanRepository.findAll();
    }
}
