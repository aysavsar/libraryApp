package com.aysavs.libraryApp.domain.aggragate.loan;
import lombok.Getter;

@Getter
public enum LoanStatus {
    PENDING,      // Beklemede
    APPROVED,     // Onaylandı
    REJECTED,     // Reddedildi
    COMPLETED,    // Tamamlandı
    OVERDUE,      // Gecikmeli
    CANCELLED;    // İptal edildi
}
