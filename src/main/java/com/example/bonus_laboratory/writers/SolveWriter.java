package com.example.bonus_laboratory.writers;

import com.example.bonus_laboratory.calculations.IndexCalc;
import com.example.bonus_laboratory.calculations.surface.SurfaceFinder;
import com.example.bonus_laboratory.models.Equation;
import org.springframework.ui.Model;

public class SolveWriter {
    IndexCalc writer = new IndexCalc();
    private Model model;
    private Equation equation;
    SurfaceFinder surfaceFinder;

    public SolveWriter() {
    }

    public SolveWriter(Model model, Equation equation) {
        this.model = model;
        this.equation = equation;

        surfaceFinder = new SurfaceFinder(equation);
    }

    // Matrix writers
    private String matrixWriter(String matrix){
        String start = "\\(\\begin{vmatrix} ";
        String end = " \\end{vmatrix} \\)";
        return start + matrix + end;
    }

    private void t1Writer(){
        StringBuilder sb = new StringBuilder();
        String t1equation = "τ₁ = "+ this.equation.getA11() +" + "+ this.equation.getA22() +" + "+ this.equation.getA33() +" = " + writer.t1Finder(equation);
        sb.append(t1equation);
        model.addAttribute("t1matrix", sb);
    }

    private void t2Writer(){
        StringBuilder sb = new StringBuilder();
        String matrix = equation.getA11() + "&" + equation.getA12() + "\\\\" + equation.getA12() + "&" + equation.getA22();
        sb.append("τ₂ = ");
        sb.append(matrixWriter(matrix));
        sb.append(" + ");
        matrix = equation.getA11() + "&" + equation.getA13() + "\\\\" + equation.getA13() + "&" + equation.getA33();
        sb.append(matrixWriter(matrix));
        sb.append(" + ");
        matrix = equation.getA22() + "&" + equation.getA23() + "\\\\" + equation.getA23() + "&" + equation.getA33();
        sb.append(matrixWriter(matrix));
        sb.append(" = ");
        sb.append(writer.t2Finder(equation));
        model.addAttribute("t2matrix", sb);
    }

    private void k2Writer(){
        StringBuilder sb = new StringBuilder();
        String matrix = equation.getA11() + "&" + equation.getA12() + "&" + equation.getA1() + "\\\\" + equation.getA12() + "&" + equation.getA22() + "&" + equation.getA2() + "\\\\" + equation.getA1() + "&" + equation.getA2() + "&" + equation.getA0();
        sb.append("k₂"+" = ");
        sb.append(matrixWriter(matrix));
        sb.append(" + ");
        matrix = equation.getA11() + "&" + equation.getA13() + "&" + equation.getA1() + "\\\\" + equation.getA13() + "&" + equation.getA33() + "&" + equation.getA3() + "\\\\" + equation.getA1() + "&" + equation.getA3() + "&" + equation.getA0();
        sb.append(matrixWriter(matrix));
        sb.append(" + ");
        matrix = equation.getA22() + "&" + equation.getA23() + "&" + equation.getA2() + "\\\\" + equation.getA23() + "&" + equation.getA33() + "&" + equation.getA3() + "\\\\" + equation.getA2() + "&" + equation.getA3() + "&" + equation.getA0();
        sb.append(matrixWriter(matrix));
        sb.append(" = ");
        sb.append(writer.k2Finder(equation));
        model.addAttribute("k2matrix", sb);
    }

    private void deltaWriter(){
        StringBuilder sb = new StringBuilder();
        String matrix = equation.getA11() + "&" + equation.getA12() + "&" + equation.getA13() + "\\\\" + equation.getA12() + "&" + equation.getA22() + "&" + equation.getA23() + "\\\\" + equation.getA13() + "&" + equation.getA23() + "&" + equation.getA33();
        sb.append("δ = ");
        sb.append(matrixWriter(matrix));
        sb.append(" = ");
        sb.append(writer.smallDeltaFinder(equation));
        model.addAttribute("deltamatrix", sb);
    }

    private void bigDetWriter(){
        StringBuilder sb = new StringBuilder();
        String matrix = equation.getA11() + "&" + equation.getA12() + "&" + equation.getA13() + "&" + equation.getA1() + "\\\\" + equation.getA12() + "&" + equation.getA22() + "&" + equation.getA23() + "&" + equation.getA2() + "\\\\" + equation.getA13() + "&" + equation.getA23() + "&" + equation.getA33() + "&" + equation.getA3() + "\\\\" + equation.getA1() + "&" + equation.getA2() + "&" + equation.getA3() + "&" + equation.getA0();
        sb.append("Δ = ");
        sb.append(matrixWriter(matrix));
        sb.append(" = ");
        sb.append(writer.bigDeltaFinder(equation));
        model.addAttribute("bigdetmatrix", sb);
    }

    public void explanation(){
        String surfaceName = surfaceFinder.getType();
        String part1 = "За таблицею (див. нижче) визначаємо, що рівняння задає " + surfaceName + ", бо:";
        String part3 = "Відповідь: " + surfaceName;

        model.addAttribute("explanation_part1", part1);
        model.addAttribute("explanation_part2", surfaceFinder.explanation);
        model.addAttribute("explanation_part3", part3);

        t1Writer();
        t2Writer();
        k2Writer();
        deltaWriter();
        bigDetWriter();
    }
}
