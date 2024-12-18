package com.aysavs.libraryApp.aplication.service.converter;

import com.aysavs.libraryApp.aplication.service.request.loan.CreateLoanRequest;
import com.aysavs.libraryApp.domain.aggragate.loan.Loan;
import org.springframework.stereotype.Component;

@Component
public class LoanRequestConverter {

    public Loan convert(CreateLoanRequest createLoanRequest){
        Loan loan =new Loan();
        loan.setBookId(createLoanRequest.getBookId());
        loan.setMemberId(createLoanRequest.getMemberId());
        loan.setLoanDate(createLoanRequest.getLoanDate());
        loan.setReturnDate(createLoanRequest.getReturnDate());
        loan.setRemainingRight(createLoanRequest.getRemainingRight());
        loan.setLoanedBookCount(createLoanRequest.getLoanedBookCount());
        loan.setForbidden(createLoanRequest.isForbidden());
        loan.setLibrarianId(createLoanRequest.getLiberianId());
        return loan;


    }
}
