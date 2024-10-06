package com.aysavs.libraryApp.infrastructure.repository;

import com.aysavs.libraryApp.domain.aggragate.author.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Long> {
}
