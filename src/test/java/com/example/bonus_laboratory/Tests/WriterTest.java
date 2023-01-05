package com.example.bonus_laboratory.Tests;

import com.example.bonus_laboratory.models.Equation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WriterTest {
    @Test
    public void equationWriter(){
        Equation equation = new Equation(1,2,3,4,5,6,7,8,9,-4);
        assertEquals(equation.EquationWriter(), "1.0x² + 2.0y² + 3.0z² + 2⋅2.0xy + 2⋅2.5xz + 2⋅3.0yz + 2⋅3.5x + 2⋅4.0y + 2⋅4.5z + -4.0 = 0");
    }
}
