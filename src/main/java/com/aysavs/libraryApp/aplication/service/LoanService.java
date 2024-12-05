package com.aysavs.libraryApp.aplication.service;

import com.aysavs.libraryApp.aplication.service.converter.LoanRequestConverter;
import com.aysavs.libraryApp.aplication.service.request.loan.CreateLoanRequest;
import com.aysavs.libraryApp.aplication.service.request.loan.UpdateLoanRequest;
import com.aysavs.libraryApp.aplication.service.validator.CreateLoanRequestValidator;
import com.aysavs.libraryApp.domain.aggragate.loan.Loan;
import com.aysavs.libraryApp.domain.aggragate.loan.LoanStatus;
import com.aysavs.libraryApp.infrastructure.repository.LoanRepository;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Optional;

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
    }
    public Long update(UpdateLoanRequest request, Long loanId) {
        Loan loan = loanRepository.findById(loanId)
                .orElseThrow(() -> new NotFoundException("Loan not found"));

        Optional.ofNullable(request.getBookId()).ifPresent(loan::setBookId);
        Optional.ofNullable(request.getMemberId()).ifPresent(loan::setMemberId);
        Optional.ofNullable(request.getLibrarianId()).ifPresent(loan::setLibrarianId);

        Optional.ofNullable(request.getLoanDate()).ifPresent(loan::setLoanDate);
        Optional.ofNullable(request.getReturnDate()).ifPresent(loan::setReturnDate);
        Optional.ofNullable(request.getRemainingRight()).ifPresent(loan::setRemainingRight);
        Optional.ofNullable(request.getLoanedBookCount()).ifPresent(loan::setLoanedBookCount);
        Optional.ofNullable(request.isForbidden()).ifPresent(loan::setForbidden);

        Optional.ofNullable(request.getLoanStatus())
                .map(String::toUpperCase)
                .map(LoanStatus::valueOf)
                .ifPresent(loan::setStatus);

        loanRepository.save(loan);
        return loanId; // Güncellenen ödünç alma işleminin ID'sini döndür
    }

}
