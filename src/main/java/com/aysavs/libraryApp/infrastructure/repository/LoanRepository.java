package com.aysavs.libraryApp.infrastructure.repository;

import com.aysavs.libraryApp.domain.aggragate.loan.Loan;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan,Long> {
}
