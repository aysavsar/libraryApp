package com.aysavs.libraryApp.domain.aggragate.author;
import lombok.Getter;

@Getter
public enum AuthorStatus {
    ACTIVE,          // Aktif olarak yazarlık yapan yazar
    RETIRED,         // Emekli olmuş yazar
    DECEASED,        // Hayatını kaybetmiş yazar
    UNKNOWN;         // Durumu bilinmeyen yazar
}
