package com.example.bonus_laboratory.Tests;

import com.example.bonus_laboratory.Calculations.SurfaceFinder;
import com.example.bonus_laboratory.Models.Equation;
import com.example.bonus_laboratory.Repo.EquationRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class EquationRepositoryTests {
    @Autowired
    private EquationRepository repo;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testAddEquation(){
        Equation equation = new Equation(1, 2, 3, 2.3, -4, 0, 0, 23, -9, 10);
        equation.setSurface_name(SurfaceFinder.Surface(equation));
        Equation savedEquation = repo.save(equation);

        Equation existEquation = entityManager.find(Equation.class, savedEquation.getId());

        assertThat(existEquation.getA11()).isEqualTo(equation.getA11());
    }
}
