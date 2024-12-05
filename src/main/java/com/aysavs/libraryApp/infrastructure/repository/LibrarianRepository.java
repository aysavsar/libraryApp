package com.aysavs.libraryApp.infrastructure.repository;

import com.aysavs.libraryApp.domain.aggragate.librarian.Librarian;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibrarianRepository extends JpaRepository<Librarian, Long> {
}
