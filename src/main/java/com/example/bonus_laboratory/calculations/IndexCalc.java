package com.example.bonus_laboratory.calculations;
import com.example.bonus_laboratory.calculations.determinant.Determinant;
import com.example.bonus_laboratory.models.Equation;

public class IndexCalc{
    Determinant determinant = new Determinant();

    public double t1Finder(Equation e){
        return e.getA11()+e.getA22()+e.getA33();
    }

    public double t2Finder(Equation e){
        double[][] matrix1 = {{e.getA11(), e.getA12()}, {e.getA12(), e.getA22()}};
        double[][] matrix2 = {{e.getA11(), e.getA13()}, {e.getA13(), e.getA33()}};
        double[][] matrix3 = {{e.getA22(), e.getA23()}, {e.getA23(), e.getA33()}};
        return determinant.determinantFinder(matrix1) + determinant.determinantFinder(matrix2) + determinant.determinantFinder(matrix3);
    }

    public double k1Finder(Equation e){
        double[][] matrix1 = {{e.getA11(), e.getA1()}, {e.getA1(), e.getA0()}};
        double[][] matrix2 = {{e.getA22(), e.getA2()}, {e.getA2(), e.getA0()}};
        double[][] matrix3 = {{e.getA33(), e.getA3()}, {e.getA3(), e.getA0()}};
        return determinant.determinantFinder(matrix1) + determinant.determinantFinder(matrix2) + determinant.determinantFinder(matrix3);
    }

    public double k2Finder(Equation e){
        double[][] matrix1 = {{e.getA11(), e.getA12(), e.getA1()}, {e.getA12(), e.getA22(), e.getA2()}, {e.getA1(), e.getA2(), e.getA0()}};
        double[][] matrix2 = {{e.getA11(), e.getA13(), e.getA1()}, {e.getA13(), e.getA33(), e.getA3()}, {e.getA1(), e.getA3(), e.getA0()}};
        double[][] matrix3 = {{e.getA22(), e.getA23(), e.getA2()}, {e.getA23(), e.getA33(), e.getA3()}, {e.getA2(), e.getA3(), e.getA0()}};
        return determinant.determinantFinder(matrix1) + determinant.determinantFinder(matrix2) + determinant.determinantFinder(matrix3);
    }

    public double smallDeltaFinder(Equation e){
        double[][] matrix = {{e.getA11(), e.getA12(), e.getA13()},{e.getA12(), e.getA22(), e.getA23()},{e.getA13(), e.getA23(), e.getA33()}};
        return determinant.determinantFinder(matrix);
    }

    public double bigDeltaFinder(Equation e){
        double[][] matrix = {{e.getA11(), e.getA12(), e.getA13(), e.getA1()},{e.getA12(), e.getA22(), e.getA23(), e.getA2()},{e.getA13(), e.getA23(), e.getA33(), e.getA3()},{e.getA1(),e.getA2(),e.getA3(),e.getA0()}};
        return determinant.determinantFinder(matrix);
    }

}
