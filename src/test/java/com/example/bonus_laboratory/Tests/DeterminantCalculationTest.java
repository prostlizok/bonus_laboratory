package com.example.bonus_laboratory.Tests;

import com.example.bonus_laboratory.Calculations.Determinant.Determinant;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeterminantCalculationTest {
    @Test
    public void checkDeterminant1() throws Exception{
        double[][] matrix = {{2,3},{1,3}};
        assertEquals(Determinant.detFinder(matrix), 3);
    }

    @Test
    public void checkDeterminant2() throws Exception{
        double[][] matrix = {{1,1,0}, {0,-2,1}, {1,4,2}};
        assertEquals(Determinant.detFinder(matrix), -7);
    }

    @Test
    public void checkDeterminant3() throws Exception{
        double[][] matrix = {{1,2,2.5,3.5}, {2,2,3,4}, {2.5,3,3,4.5}, {3.5,4,4.5,-4}};
        assertEquals(Determinant.detFinder(matrix), -26.25);
    }


}
