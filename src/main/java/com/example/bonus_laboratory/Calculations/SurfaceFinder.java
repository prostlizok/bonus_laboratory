package com.example.bonus_laboratory.Calculations;

import com.example.bonus_laboratory.Models.Equation;

public class SurfaceFinder {

    public static boolean existSurface(Equation equation){
        if (equation.getA11() == 0 && equation.getA22() == 0 && equation.getA33() == 0 && equation.getA12() == 0 && equation.getA13() == 0 && equation.getA23() == 0 && equation.getA1() == 0 && equation.getA2() == 0 && equation.getA3() == 0 && equation.getA0() == 0){
            return false;
        }
        return true;
    }
    public static String Surface(Equation equation) {
        double t1 = IndexCalc.t1(equation);
        double t2 = IndexCalc.t2(equation);
        double delta = IndexCalc.delta(equation);
        double bigDet = IndexCalc.bigDeterminant(equation);
        double k2 = IndexCalc.k2(equation);

        if (delta == 0) {
            SolveWriter.inv_explanation += "δ = 0, ";
            if (bigDet == 0) {
                SolveWriter.inv_explanation += "Δ = 0, ";
                if (t2 == 0) {
                    SolveWriter.inv_explanation += "τ₂ = 0, ";
                    if (k2 == 0) {
                        SolveWriter.inv_explanation += "k₂ = 0, ";
                        double k1 = IndexCalc.k1(equation);
                        SolveWriter.k1_use_check = true;
                        if (k1 == 0) {
                            return "Пара площин, що збігаються";
                        } else if (k1 > 0) {
                            return "Пара уявних паралельний площин";
                        } else if (k1 < 0) {
                            return "Пара паралельний площин";
                        }
                    } else {
                        SolveWriter.inv_explanation += "k₂ ≠ 0, ";
                        return "Параболічний циліндр";
                        }
                } else if (t2 > 0) {
                    SolveWriter.inv_explanation += "τ₂ > 0, ";
                    if (k2 == 0){
                        SolveWriter.inv_explanation += "k₂ = 0.";
                        return "Пара уявних площин, що перетинаються";
                    }else if (t1*k2>0){
                        SolveWriter.inv_explanation += "k₂⋅τ₁ > 0.";
                        return "Уявний еліптичний циліндр";
                    } else if (t1*k2<0) {
                        SolveWriter.inv_explanation += "k₂⋅τ₁ < 0.";
                        return "Еліптичний циліндр";
                    }
                } else if (t2 < 0) {
                    SolveWriter.inv_explanation += "τ₂ < 0, ";
                    if (k2 == 0){
                        SolveWriter.inv_explanation += "k₂ = 0.";
                        return "Пара пересікаючихся площин";
                    }else {
                        SolveWriter.inv_explanation += "k₂ ≠ 0.";
                        return "Гіперболічний циліндр";
                    }
                }

            } else if (bigDet < 0) {
                SolveWriter.inv_explanation += "Δ < 0.";
                return "Еліптичний парабалоїд";
            } else if (bigDet > 0) {
                SolveWriter.inv_explanation += "Δ > 0.";
                return "Гіперболічний параболоїд";
            }
        } else {
            SolveWriter.inv_explanation += "δ ≠ 0, ";
            if (t2 > 0 && t1 * delta > 0) {
                SolveWriter.inv_explanation += "τ₂ > 0, τ₁⋅δ > 0, ";
                if (bigDet == 0) {
                    SolveWriter.inv_explanation += "Δ = 0.";
                    return "Уявний конус";
                } else if (bigDet > 0) {
                    SolveWriter.inv_explanation += "Δ > 0.";
                    return "Уявний еліпсоїд";
                } else if (bigDet < 0) {
                    SolveWriter.inv_explanation += "Δ < 0.";
                    return "Еліпсоїд";
                }
            } else {
                SolveWriter.inv_explanation += "τ₂ ≤ 0, τ₁⋅δ ≤ 0, ";
                if (bigDet == 0) {
                    SolveWriter.inv_explanation += "Δ = 0.";
                    return "Конус";
                } else if (bigDet > 0) {
                    SolveWriter.inv_explanation += "Δ > 0.";
                    return "Однополосний гіперболоїд";
                } else if (bigDet < 0) {
                    SolveWriter.inv_explanation += "Δ < 0.";
                    return "Двополосний гіперболоїд";
                }
            }
        }
        return "Площини не існує!";
    }
}
