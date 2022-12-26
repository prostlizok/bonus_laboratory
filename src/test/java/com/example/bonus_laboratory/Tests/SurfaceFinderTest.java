package com.example.bonus_laboratory.Tests;

import com.example.bonus_laboratory.Calculations.SurfaceFinder;
import com.example.bonus_laboratory.Models.Equation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SurfaceFinderTest extends SurfaceFinder {
    Equation equation1 = new Equation(1,2,3,4,5,6,7,8,9,-4);
    Equation equation2 = new Equation(0,2,3,0,0,0,3,0,9,-4);
    Equation equation3 = new Equation(0,0,3,2,4,3,0,0,0,0);

    @Test
    public void SurfaceCheck1() throws Exception{
        assertEquals(Surface(equation1), "Двополосний гіперболоїд");
    }

    @Test
    public void SurfaceCheck2() throws Exception{
        assertEquals(Surface(equation2), "Еліптичний парабалоїд");
    }

    @Test
    public void SurfaceCheck3() throws Exception{
        assertEquals(Surface(equation3), "Конус");
    }
}
