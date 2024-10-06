package com.aysavs.libraryApp.infrastructure.repository;

import com.aysavs.libraryApp.domain.aggragate.liberian.Liberian;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LiberianRepository extends JpaRepository<Liberian,Long> {
}
