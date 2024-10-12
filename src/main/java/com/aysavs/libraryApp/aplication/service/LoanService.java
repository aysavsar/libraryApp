package com.aysavs.libraryApp.aplication.service;

import com.aysavs.libraryApp.aplication.service.converter.LoanRequestConverter;
import com.aysavs.libraryApp.aplication.service.request.CreateLoanRequest;
import com.aysavs.libraryApp.aplication.service.validator.CreateLoanRequestValidator;
import com.aysavs.libraryApp.domain.aggragate.loan.Loan;
import com.aysavs.libraryApp.infrastructure.repository.LoanRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LoanService {

    private final LoanRepository loanRepository;
    private final CreateLoanRequestValidator createLoanRequestValidator;
    private final LoanRequestConverter loanRequestConverter ;


    public LoanService(LoanRepository loanRepository,
                       LoanRequestConverter loanRequestConverter,
                       CreateLoanRequestValidator createLoanRequestValidator) {
        this.loanRepository = loanRepository;
        this.loanRequestConverter=loanRequestConverter;
        this.createLoanRequestValidator=createLoanRequestValidator;
    }

    public List<Loan> getAll() {
        return loanRepository.findAll();
    }
    public Long create(CreateLoanRequest createLoanRequest ) {
        createLoanRequestValidator.validate(createLoanRequest);
        Loan loan = loanRequestConverter.convert(createLoanRequest);
        Loan savedLoan  = loanRepository.save(loan);

        return savedLoan.getId();
}}
