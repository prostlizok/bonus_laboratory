package com.example.bonus_laboratory.repo;

import com.example.bonus_laboratory.models.Equation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquationRepository extends JpaRepository<Equation, Long> {
}
