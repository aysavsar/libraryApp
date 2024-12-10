package com.aysavs.libraryApp.domain.aggragate.loan;
import lombok.Getter;

@Getter
public enum LoanStatus {
    RETURNED,     // Geri alınan kitap
    PENDING,      // Beklemede
    APPROVED,     // Onaylandı
    REJECTED,     // Reddedildi
    COMPLETED,    // Tamamlandı
    OVERDUE,      // Gecikmeli Süresi geçmiş ödünç alınan kitap
    CANCELLED;   // İptal edildi
}
