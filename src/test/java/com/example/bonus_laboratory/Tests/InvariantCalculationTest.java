package com.example.bonus_laboratory.Tests;

import com.example.bonus_laboratory.calculations.IndexCalc;
import com.example.bonus_laboratory.models.Equation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InvariantCalculationTest extends IndexCalc {
    Equation equation1 = new Equation(1,2,3,4,5,6,7,8,9,-4);
    Equation equation2 = new Equation(0,0,3,0,0,0,0,0,9,-4);

    @Test
    public void t1Check(){
        assertEquals(t1Finder(equation1), 6);
    }

    @Test
    public void t2Check(){
        assertEquals(t2Finder(equation1), -8.25);
    }

    @Test
    public void deltaCheck(){
        assertEquals(smallDeltaFinder(equation1), 2.5);
    }

    @Test
    public void bigDeltaCheck(){
        assertEquals(bigDeltaFinder(equation1), -26.25);
    }

    @Test
    public void k1Check(){
        assertEquals(k1Finder(equation2), -32.25);
    }

    @Test
    public void k2Check(){
        assertEquals(k2Finder(equation2), 0);
    }


}
