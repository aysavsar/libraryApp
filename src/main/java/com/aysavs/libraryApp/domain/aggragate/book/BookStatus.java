package com.aysavs.libraryApp.domain.aggragate.book;

import lombok.Getter;

@Getter
public enum BookStatus {
    AVAILABLE,
    DAMAGED,
    LOST,
    OUT_OF_USE,
    UNKNOWN;


}
