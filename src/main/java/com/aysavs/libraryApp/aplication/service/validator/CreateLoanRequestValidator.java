package com.aysavs.libraryApp.aplication.service.validator;

import com.aysavs.libraryApp.aplication.service.request.loan.CreateLoanRequest;
import jakarta.validation.ValidationException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class CreateLoanRequestValidator {

    public void validate(CreateLoanRequest createLoanRequest) {
        validateBookId(createLoanRequest.getBookId());
        validateMemberId(createLoanRequest.getMemberId());
        validateLibrarianId(createLoanRequest.getLiberianId());
        validateLoanStatus(createLoanRequest.getLoanStatus());
        validateRemainingRight(createLoanRequest.getRemainingRight());
        validateLoanedBookCount(createLoanRequest.getLoanedBookCount());
        validateLoanDate(createLoanRequest.getLoanDate());
        validateRefundDate(createLoanRequest.getReturnDate());
    }

    private void validateBookId(long bookId) {
        if (bookId <= 0) {
            throw new ValidationException("Invalid book ID.");
        }
    }

    private void validateMemberId(long memberId) {
        if (memberId <= 0) {
            throw new ValidationException("Invalid member ID.");
        }
    }

    private void validateLibrarianId(long librarianId) {
        if (librarianId <= 0) {
            throw new ValidationException("Invalid librarian ID.");
        }
    }

    private void validateLoanStatus(String loanStatus) {
        if (!StringUtils.hasText(loanStatus)) {
            throw new ValidationException("Loan status cannot be blank.");
        }
    }

    private void validateRemainingRight(int remainingRight) {
        if (remainingRight < 0) {
            throw new ValidationException("Remaining right must be a positive number.");
        }
    }

    private void validateLoanedBookCount(int loanedBookCount) {
        if (loanedBookCount < 0) {
            throw new ValidationException("Loaned book count must be a positive number.");
        }
    }

    private void validateLoanDate(java.util.Date loanDate) {
        if (loanDate == null) {
            throw new ValidationException("Loan date cannot be null.");
        }
    }

    private void validateRefundDate(java.util.Date refundDate) {
        if (refundDate == null) {
            throw new ValidationException("Refund date cannot be null.");
        }
    }
}
