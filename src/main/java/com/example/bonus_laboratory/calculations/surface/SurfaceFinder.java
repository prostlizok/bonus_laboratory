package com.example.bonus_laboratory.calculations.surface;

import com.example.bonus_laboratory.calculations.IndexCalc;
import com.example.bonus_laboratory.writers.SolveWriter;
import com.example.bonus_laboratory.models.Equation;

public class SurfaceFinder {
    private final Equation equation;
    private final double t1, t2, smallDelta, bigDelta, k1, k2;
    public String explanation = "";

    IndexCalc indexCalc = new IndexCalc();

    // Constructors
    public SurfaceFinder(Equation equation){
        this.equation = equation;

        // Indexes calculation
        t1 = indexCalc.t1Finder(equation);
        t2 = indexCalc.t2Finder(equation);
        smallDelta = indexCalc.smallDeltaFinder(equation);
        bigDelta = indexCalc.bigDeltaFinder(equation);
        k1 = indexCalc.k1Finder(equation);
        k2 = indexCalc.k2Finder(equation);
    }

    public boolean existSurface(){
        return equation.getA11() != 0 || equation.getA22() != 0 || equation.getA33() != 0 || equation.getA12() != 0 || equation.getA13() != 0 || equation.getA23() != 0 || equation.getA1() != 0 || equation.getA2() != 0 || equation.getA3() != 0 || equation.getA0() != 0;
    }

    // Surface type
    public String getType(){
        SurfaceType type = typeFinder();
        return type.getName();
    }

    public SurfaceType typeFinder() {
        if (smallDelta != 0){
            if (t2 > 0 && t1 * smallDelta > 0){
                explanation += "δ ≠ 0, τ₂ > 0, τ₁⋅δ > 0, ";
                return ellipseType();
            }else{
                explanation += "δ ≠ 0, τ₂ ≤ 0, τ₁⋅δ ≤ 0, ";
                return hyperbolicType();
            }
        } else {
            explanation += "δ = 0, ";
            return parabolicType();
        }
    }

    // Elliptic type parameters
    private SurfaceType ellipseType(){
        if (bigDelta > 0){
            explanation += "Δ > 0.";
            return SurfaceType.IMAGINARY_ELLIPSOID;
        }else if (bigDelta < 0){
            explanation += "Δ < 0.";
            return SurfaceType.ELLIPSOID;
        } else {
            explanation += "Δ = 0.";
            return SurfaceType.IMAGINARY_CONE;
        }
    }

    // Hyperbolic type parameters
    private SurfaceType hyperbolicType(){
        if (bigDelta > 0){
            explanation += "Δ > 0.";
            return SurfaceType.ONE_SHEETED_HYPERBOLOID;
        }else if (bigDelta < 0){
            explanation += "Δ < 0.";
            return SurfaceType.TWO_SHEETED_HYPERBOLOID;
        } else {
            explanation += "Δ = 0.";
            return SurfaceType.CONE;
        }
    }

    // Parabolic type parameters
    private SurfaceType parabolicType(){
        if (bigDelta > 0){
            explanation += "Δ > 0.";
            return SurfaceType.HYPERBOLIC_PARABOLOID;
        }else if (bigDelta < 0){
            explanation += "Δ < 0.";
            return SurfaceType.ELLIPTICAL_PARABOLOID;
        } else {
            explanation += "Δ = 0, ";
            return tau2Relations();
        }
    }

    private SurfaceType tau2Relations(){
        if (t2 > 0){
            explanation += "τ₂ > 0.";
            return t2GreaterThanZeroRelations();
        }else if (t2 < 0){
            explanation += "τ₂ < 0.";
            return t2LessThanZeroRelations();
        } else {
            explanation += "τ₂ = 0, ";
            return t2EqualsToZeroRelations();
        }
    }

    private SurfaceType t2LessThanZeroRelations(){
        if (k2 == 0){
            explanation += "k₂ = 0.";
            return SurfaceType.PAIR_OF_INTERSECTING_PLANES;
        }else{
            explanation += "k₂ ≠ 0.";
            return SurfaceType.HYPERBOLIC_CYLINDER;
        }
    }

    private SurfaceType t2GreaterThanZeroRelations(){
        if (k2 * t1 < 0){
            explanation += "k₂⋅τ₁ < 0.";
            return SurfaceType.ELLIPTICAL_CYLINDER;
        }else if (k2 * t1 > 0){
            explanation += "k₂⋅τ₁ > 0.";
            return SurfaceType.IMAGINARY_ELLIPTICAL_CYLINDER;
        } else {
            explanation += "k₂ = 0.";
            return SurfaceType.PAIR_OF_IMAGINARY_INTERSECTING_PLANES;
        }
    }

    private SurfaceType t2EqualsToZeroRelations(){
        if (k2 == 0){
            explanation += "k₂ = 0.";
            return k1Relations();
        }else{
            explanation += "k₂ ≠ 0.";
            return SurfaceType.PARABOLIC_CYLINDER;
        }
    }

    private SurfaceType k1Relations(){
        if (k1 > 0){
            return SurfaceType.PAIR_OF_IMAGINARY_PARALLEL_PLANES;
        } else if (k1 < 0) {
            return SurfaceType.PAIR_OF_PARALLEL_PLANES;
        }else{
            return SurfaceType.PAIR_OF_COINCIDENT_PLANES;
        }
    }
}
