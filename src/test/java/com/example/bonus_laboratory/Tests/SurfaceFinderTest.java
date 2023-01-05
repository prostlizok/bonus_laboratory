package com.example.bonus_laboratory.Tests;

import com.example.bonus_laboratory.calculations.surface.SurfaceFinder;
import com.example.bonus_laboratory.models.Equation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SurfaceFinderTest{
    @Test
    public void SurfaceCheck1(){
        SurfaceFinder surfaceFinder = new SurfaceFinder(new Equation(1,2,3,4,5,6,7,8,9,-4));
        assertEquals(surfaceFinder.getType(), "Двопорожнинний гіперболоїд");
    }

    @Test
    public void SurfaceCheck2(){
        SurfaceFinder surfaceFinder = new SurfaceFinder(new Equation(0,2,3,0,0,0,3,0,9,-4));
        assertEquals(surfaceFinder.getType(), "Еліптичний параболоїд");
    }

    @Test
    public void SurfaceCheck3(){
        SurfaceFinder surfaceFinder = new SurfaceFinder(new Equation(0,0,3,2,4,3,0,0,0,0));
        assertEquals(surfaceFinder.getType(), "Конус");
    }
    @Test
    public void SurfaceCheck4(){
        SurfaceFinder surfaceFinder = new SurfaceFinder(new Equation(1,1,1,2,0,0,0,0,0,0));
        assertEquals(surfaceFinder.getType(), "Пара уявних перетинаючихся площин");
    }

    @Test
    public void SurfaceCheck5(){
        SurfaceFinder surfaceFinder = new SurfaceFinder(new Equation(3,0,0,0,0,0,0,0,0,0));
        assertEquals(surfaceFinder.getType(), "Пара співпадаючих площин");
    }

    @Test
    public void SurfaceCheck6(){
        SurfaceFinder surfaceFinder = new SurfaceFinder(new Equation(3,3,4,0,0,0,0,0,0,0));
        assertEquals(surfaceFinder.getType(), "Уявний конус");
    }

    @Test
    public void SurfaceCheck7(){
        SurfaceFinder surfaceFinder = new SurfaceFinder(new Equation(0,0,0,5,2,-5,0,4,0,0));
        assertEquals(surfaceFinder.getType(), "Однопорожнинний гіперболоїд");
    }

    @Test
    public void SurfaceCheck8(){
        SurfaceFinder surfaceFinder = new SurfaceFinder(new Equation(0,0,0,0,1,3.4,0,4,0,0));
        assertEquals(surfaceFinder.getType(), "Гіперболічний парабалоїд");
    }

    @Test
    public void SurfaceCheck9(){
        SurfaceFinder surfaceFinder = new SurfaceFinder(new Equation(2,2,2,0,1,3.4,0,4,0,0));
        assertEquals(surfaceFinder.getType(), "Еліпсоїд");
    }

    @Test
    public void SurfaceCheck10(){
        SurfaceFinder surfaceFinder = new SurfaceFinder(new Equation(3,0,0,0,0,0,0,0,0,-3));
        assertEquals(surfaceFinder.getType(), "Пара паралельних площин");
    }

    @Test
    public void SurfaceCheck11(){
        SurfaceFinder surfaceFinder = new SurfaceFinder(new Equation(4,0,0,0,0,0,4,-4,34,0));
        assertEquals(surfaceFinder.getType(), "Параболічний циліндр");
    }

    @Test
    public void SurfaceCheck12(){
        SurfaceFinder surfaceFinder = new SurfaceFinder(new Equation(2,2,2,0,1,3.4,0,4,0,20));
        assertEquals(surfaceFinder.getType(), "Уявний еліпсоїд");
    }

    @Test
    public void SurfaceCheck13(){
        SurfaceFinder surfaceFinder = new SurfaceFinder(new Equation(1,1,1,2,0,0,0,0,0,2));
        assertEquals(surfaceFinder.getType(), "Уявний еліптичний циліндр");
    }
    @Test
    public void SurfaceCheck14(){
        SurfaceFinder surfaceFinder = new SurfaceFinder(new Equation(1,1,1,2,0,0,0,0,0,-2));
        assertEquals(surfaceFinder.getType(), "Еліптичний циліндр");
    }

    @Test
    public void SurfaceCheck15(){
        SurfaceFinder surfaceFinder = new SurfaceFinder(new Equation(1,-1,0,2,0,0,0,0,0,0));
        assertEquals(surfaceFinder.getType(), "Пара перетинаючихся площин");
    }

    @Test
    public void SurfaceCheck16(){
        SurfaceFinder surfaceFinder = new SurfaceFinder(new Equation(1,-1,0,2,0,0,0,0,0,4));
        assertEquals(surfaceFinder.getType(), "Гіперболічний циліндр");
    }

    @Test
    public void SurfaceCheck17(){
        SurfaceFinder surfaceFinder = new SurfaceFinder(new Equation(3,0,0,0,0,0,0,0,0,3));
        assertEquals(surfaceFinder.getType(), "Пара уявних паралельних площин");
    }

    @Test
    public void SurfaceErrorCheck(){
        SurfaceFinder surfaceFinder = new SurfaceFinder(new Equation(0,0,0,0,0,0,0,0,0,3));
        Assertions.assertTrue(surfaceFinder.existSurface());
    }
}
