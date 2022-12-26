package com.example.bonus_laboratory.Calculations.Determinant;

public class Determinant {
    public static double detFinder(double matrix[][]){
        double determinant = 0;
        if(matrix.length==1){
            determinant=matrix[0][0];
            return determinant;
        }
        if(matrix.length==2){
            determinant=matrix[0][0]*matrix[1][1] - matrix[0][1] * matrix[1][0];
            return determinant;
        }
        for(int m = 0; m < matrix[0].length; m++){
            double[][] temp = new double[matrix.length-1][matrix[0].length-1];

            for(int j = 1; j < matrix.length; j++){
                for(int y = 0; y < matrix[0].length; y++){
                    if(y < m){
                        temp[j-1][y]=matrix[j][y];
                    }
                    else if(y > m){
                        temp[j-1][y-1]=matrix[j][y];
                    }
                }
            }
            determinant += matrix[0][m] * Math.pow(-1,(int)m) * detFinder(temp);
        }
        return determinant;
    }
}
