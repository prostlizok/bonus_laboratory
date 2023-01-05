package com.example.bonus_laboratory.controllers;
import com.example.bonus_laboratory.writers.SolveWriter;
import com.example.bonus_laboratory.models.Equation;
import com.example.bonus_laboratory.repo.EquationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.bonus_laboratory.calculations.surface.SurfaceFinder;


@Controller
public class SolveController {

    @Autowired
    private EquationRepository equationRepository;

    @PostMapping("/solve")
    public String solvePage(double a11, double a22, double a33, double a12, double a13, double a23, double a1, double a2, double a3, double a0, Model model){
        Equation equation = new Equation(a11, a22, a33, a12, a13, a23, a1, a2, a3, a0);

        SurfaceFinder surfaceFinder = new SurfaceFinder(equation);
        SolveWriter writer = new SolveWriter(model, equation);

        model.addAttribute("equation", equation);

        // Error handling
        if (!surfaceFinder.existSurface()) {
            return "redirect:surface_error";
        }

        // Setting surface type
        equation.setSurface_name(surfaceFinder.getType());
        model.addAttribute("surface", equation.getSurface_name());

        writer.explanation();

        equationRepository.save(equation);
        return "solve_page";
    }

}
