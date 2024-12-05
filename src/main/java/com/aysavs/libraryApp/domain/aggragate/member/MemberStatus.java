package com.aysavs.libraryApp.domain.aggragate.member;
import lombok.Getter;

@Getter
public enum MemberStatus {
    ACTIVE,        // Aktif üye
    INACTIVE,      // Pasif üye
    SUSPENDED,     // Askıya alınmış üye
    TERMINATED,    // Üyeliği sona ermiş üye
    UNKNOWN;
}
