package com.example.bonus_laboratory.Tests;

import com.example.bonus_laboratory.calculations.surface.SurfaceFinder;
import com.example.bonus_laboratory.models.Equation;
import com.example.bonus_laboratory.repo.EquationRepository;
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
    public void testAddEquation1(){
        Equation equation = new Equation(1, 2, 3, 2.3, -4, 0, 0, 23, -9, 10);
        SurfaceFinder surfaceFinder = new SurfaceFinder(equation);
        equation.setSurface_name(surfaceFinder.getType());

        Equation savedEquation = repo.save(equation);
        Equation existEquation = entityManager.find(Equation.class, savedEquation.getId());
        assertThat(existEquation.getA11()).isEqualTo(equation.getA11());
    }

    @Test
    public void testAddEquation2(){
        Equation equation = new Equation(1, 2, 3, 2.3, -4, 0, 0, 23, -9, 10);
        SurfaceFinder surfaceFinder = new SurfaceFinder(equation);
        equation.setSurface_name(surfaceFinder.getType());

        Equation savedEquation = repo.save(equation);
        Equation existEquation = entityManager.find(Equation.class, savedEquation.getId());
        assertThat(existEquation.getSurface_name()).isEqualTo(equation.getSurface_name());
    }
}
