package com.example.bonus_laboratory.Calculations;
import com.example.bonus_laboratory.Calculations.Determinant.Determinant;
import com.example.bonus_laboratory.Models.Equation;

public class IndexCalc extends Determinant{

    public static double t1(Equation e){
        return e.getA11()+e.getA22()+e.getA33();
    }

    public static double t2(Equation e){
        double[][] matrix1 = {{e.getA11(), e.getA12()}, {e.getA12(), e.getA22()}};
        double[][] matrix2 = {{e.getA11(), e.getA13()}, {e.getA13(), e.getA33()}};
        double[][] matrix3 = {{e.getA22(), e.getA23()}, {e.getA23(), e.getA33()}};
        return detFinder(matrix1) + detFinder(matrix2) + detFinder(matrix3);
    }

    public static double k1(Equation e){
        double[][] matrix1 = {{e.getA11(), e.getA1()}, {e.getA1(), e.getA0()}};
        double[][] matrix2 = {{e.getA22(), e.getA2()}, {e.getA2(), e.getA0()}};
        double[][] matrix3 = {{e.getA33(), e.getA3()}, {e.getA3(), e.getA0()}};
        return detFinder(matrix1) + detFinder(matrix2) + detFinder(matrix3);
    }

    public static double k2(Equation e){
        double[][] matrix1 = {{e.getA11(), e.getA12(), e.getA1()}, {e.getA12(), e.getA22(), e.getA2()}, {e.getA1(), e.getA2(), e.getA0()}};
        double[][] matrix2 = {{e.getA11(), e.getA13(), e.getA1()}, {e.getA13(), e.getA33(), e.getA3()}, {e.getA1(), e.getA3(), e.getA0()}};
        double[][] matrix3 = {{e.getA22(), e.getA23(), e.getA2()}, {e.getA23(), e.getA33(), e.getA3()}, {e.getA2(), e.getA3(), e.getA0()}};
        return detFinder(matrix1) + detFinder(matrix2) + detFinder(matrix3);
    }

    public static double delta(Equation e){
        double[][] matrix = {{e.getA11(), e.getA12(), e.getA13()},{e.getA12(), e.getA22(), e.getA23()},{e.getA13(), e.getA23(), e.getA33()}};
        return detFinder(matrix);
    }

    public static double bigDeterminant(Equation e){
        double[][] matrix = {{e.getA11(), e.getA12(), e.getA13(), e.getA1()},{e.getA12(), e.getA22(), e.getA23(), e.getA2()},{e.getA13(), e.getA23(), e.getA33(), e.getA3()},{e.getA1(),e.getA2(),e.getA3(),e.getA0()}};
        return detFinder(matrix);
    }

}
