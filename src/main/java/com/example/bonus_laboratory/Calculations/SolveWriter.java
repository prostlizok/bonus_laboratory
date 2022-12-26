package com.example.bonus_laboratory.Calculations;

import com.example.bonus_laboratory.Models.Equation;
import org.springframework.ui.Model;

public class SolveWriter {
    private Model model;
    private Equation equation;

    public SolveWriter() {
    }

    public SolveWriter(Model model, Equation equation) {
        this.model = model;
        this.equation = equation;
    }

    // Matrix writers
    private static String MatrixWriter(String matrix){
        String start = "\\(\\begin{vmatrix} ";
        String end = " \\end{vmatrix} \\)";
        return start + matrix + end;
    }

    private void t1Writer(){
        StringBuilder sb = new StringBuilder();
        String t1equation = "τ₁ = "+ this.equation.getA11() +" + "+ this.equation.getA22() +" + "+ this.equation.getA33() +" = " + IndexCalc.t1(equation);
        sb.append(t1equation);
        model.addAttribute("t1matrix", sb);
    }

    private void t2Writer(){
        StringBuilder sb = new StringBuilder();
        String matrix = equation.getA11() + "&" + equation.getA12() + "\\\\" + equation.getA12() + "&" + equation.getA22();
        sb.append("τ₂ = ");
        sb.append(MatrixWriter(matrix));
        sb.append(" + ");
        matrix = equation.getA11() + "&" + equation.getA13() + "\\\\" + equation.getA13() + "&" + equation.getA33();
        sb.append(MatrixWriter(matrix));
        sb.append(" + ");
        matrix = equation.getA22() + "&" + equation.getA23() + "\\\\" + equation.getA23() + "&" + equation.getA33();
        sb.append(MatrixWriter(matrix));
        sb.append(" = ");
        sb.append(IndexCalc.t2(equation));
        model.addAttribute("t2matrix", sb);
    }

    private void k1Writer(){
        StringBuilder sb = new StringBuilder();
        String matrix = equation.getA11() + "&" + equation.getA1() + "\\\\" + equation.getA1() + "&" + equation.getA0();
        sb.append("k₁"+" = ");
        sb.append(MatrixWriter(matrix));
        sb.append(" + ");
        matrix = equation.getA22() + "&" + equation.getA2() + "\\\\" + equation.getA2() + "&" + equation.getA0();
        sb.append(MatrixWriter(matrix));
        sb.append(" + ");
        matrix = equation.getA33() + "&" + equation.getA3() + "\\\\" + equation.getA3() + "&" + equation.getA0();
        sb.append(MatrixWriter(matrix));
        sb.append(" = ");
        sb.append(IndexCalc.k1(equation));
        model.addAttribute("k1matrix", sb);
    }

    private void k2Writer(){
        StringBuilder sb = new StringBuilder();
        String matrix = equation.getA11() + "&" + equation.getA12() + "&" + equation.getA1() + "\\\\" + equation.getA12() + "&" + equation.getA22() + "&" + equation.getA2() + "\\\\" + equation.getA1() + "&" + equation.getA2() + "&" + equation.getA0();
        sb.append("k₂"+" = ");
        sb.append(MatrixWriter(matrix));
        sb.append(" + ");
        matrix = equation.getA11() + "&" + equation.getA13() + "&" + equation.getA1() + "\\\\" + equation.getA13() + "&" + equation.getA33() + "&" + equation.getA3() + "\\\\" + equation.getA1() + "&" + equation.getA3() + "&" + equation.getA0();
        sb.append(MatrixWriter(matrix));
        sb.append(" + ");
        matrix = equation.getA22() + "&" + equation.getA23() + "&" + equation.getA2() + "\\\\" + equation.getA23() + "&" + equation.getA33() + "&" + equation.getA3() + "\\\\" + equation.getA2() + "&" + equation.getA3() + "&" + equation.getA0();
        sb.append(MatrixWriter(matrix));
        sb.append(" = ");
        sb.append(IndexCalc.k2(equation));
        model.addAttribute("k2matrix", sb);
    }

    private void deltaWriter(){
        StringBuilder sb = new StringBuilder();
        String matrix = equation.getA11() + "&" + equation.getA12() + "&" + equation.getA13() + "\\\\" + equation.getA12() + "&" + equation.getA22() + "&" + equation.getA23() + "\\\\" + equation.getA13() + "&" + equation.getA23() + "&" + equation.getA33();
        sb.append("δ = ");
        sb.append(MatrixWriter(matrix));
        sb.append(" = ");
        sb.append(IndexCalc.delta(equation));
        model.addAttribute("deltamatrix", sb);
    }

    private void bigDetWriter(){
        StringBuilder sb = new StringBuilder();
        String matrix = equation.getA11() + "&" + equation.getA12() + "&" + equation.getA13() + "&" + equation.getA1() + "\\\\" + equation.getA12() + "&" + equation.getA22() + "&" + equation.getA23() + "&" + equation.getA2() + "\\\\" + equation.getA13() + "&" + equation.getA23() + "&" + equation.getA33() + "&" + equation.getA3() + "\\\\" + equation.getA1() + "&" + equation.getA2() + "&" + equation.getA3() + "&" + equation.getA0();
        sb.append("Δ = ");
        sb.append(MatrixWriter(matrix));
        sb.append(" = ");
        sb.append(IndexCalc.bigDeterminant(equation));
        model.addAttribute("bigdetmatrix", sb);
    }

    // Check if k1 was calculated
    public static boolean k1_use_check = false;

    public static String inv_explanation = "";

    public void Explanation(){
        String part1 = "За таблицею (див. нижче) визначаємо, що рівняння задає " + equation.getSurface_name() + ", бо:";
        String part3 = "Відповідь: " + equation.getSurface_name();
        model.addAttribute("explanation_part1", part1);
        model.addAttribute("explanation_part2", inv_explanation);
        model.addAttribute("explanation_part3", part3);

        t1Writer();
        t2Writer();
        if (k1_use_check){k1Writer();}
        k2Writer();
        deltaWriter();
        bigDetWriter();
    }
}
