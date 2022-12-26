package com.example.bonus_laboratory.Controllers;
import com.example.bonus_laboratory.Calculations.SolveWriter;
import com.example.bonus_laboratory.Models.Equation;
import com.example.bonus_laboratory.Repo.EquationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.bonus_laboratory.Calculations.SurfaceFinder;


@Controller
public class SolveController {

    @Autowired
    private EquationRepository equationRepository;

    @PostMapping("/solve")
    public String solvePage(double a11, double a22, double a33, double a12, double a13, double a23, double a1, double a2, double a3, double a0, Model model){
        Equation equation = new Equation(a11, a12, a13, a22, a23, a33, a1, a2, a3, a0);
        model.addAttribute("equation", equation);

        // Error handling
        if (!SurfaceFinder.existSurface(equation)) {
            MainController.error_check = 1;
            return "redirect:";
        }else{
            MainController.error_check = 0;
        }


        SolveWriter writer = new SolveWriter(model, equation);

        // Setting surface type
        equation.setSurface_name(SurfaceFinder.Surface(equation));
        model.addAttribute("surface", equation.getSurface_name());

        writer.Explanation();
        SolveWriter.inv_explanation = "";

        equationRepository.save(equation);
        return "solve_page";
    }

}
