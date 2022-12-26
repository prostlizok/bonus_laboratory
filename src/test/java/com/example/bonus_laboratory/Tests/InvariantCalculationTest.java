package com.example.bonus_laboratory.Tests;

import com.example.bonus_laboratory.Calculations.IndexCalc;
import com.example.bonus_laboratory.Models.Equation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InvariantCalculationTest extends IndexCalc {
    Equation equation1 = new Equation(1,2,3,4,5,6,7,8,9,-4);
    Equation equation2 = new Equation(0,0,3,0,0,0,0,0,9,-4);

    @Test
    public void t1Check() throws Exception{
        assertEquals(t1(equation1), 6);
    }

    @Test
    public void t2Check() throws Exception{
        assertEquals(t2(equation1), -8.25);
    }

    @Test
    public void deltaCheck() throws Exception{
        assertEquals(delta(equation1), 2.5);
    }

    @Test
    public void bigDeltaCheck() throws Exception{
        assertEquals(bigDeterminant(equation1), -26.25);
    }

    @Test
    public void k1Check() throws Exception{
        assertEquals(k1(equation2), -32.25);
    }

    @Test
    public void k2Check() throws Exception{
        assertEquals(k2(equation2), 0);
    }


}
