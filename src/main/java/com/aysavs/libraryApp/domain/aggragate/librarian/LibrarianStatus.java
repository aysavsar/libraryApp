package com.aysavs.libraryApp.domain.aggragate.librarian;

import lombok.Getter;

@Getter
public enum LibrarianStatus {
    ACTIVE,       // Aktif kütüphaneci
    INACTIVE,     // Pasif kütüphaneci
    SUSPENDED,    // Askıya alınmış kütüphaneci
    TERMINATED,   // Görevden alınmış kütüphaneci
    UNKNOWN;      // Durumu bilinmeyen kütüphaneci
}