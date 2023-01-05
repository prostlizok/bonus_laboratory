package com.example.bonus_laboratory.controllers;

import com.example.bonus_laboratory.models.Equation;
import com.example.bonus_laboratory.repo.EquationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @Autowired
    private EquationRepository equationRepository;
    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("equation", new Equation());

        // DB display
        Iterable<Equation> equations = equationRepository.findAll();
        model.addAttribute("equations", equations);
        return "index";
    }

    @GetMapping("/freedb")
    public String freeDB(Model model){
        model.addAttribute("equation", new Equation());
        equationRepository.deleteAll();
        return "index";
    }

    @GetMapping("/surface_error")
    public String errorDB(Model model){
        model.addAttribute("equation", new Equation());
        model.addAttribute("error_message", "Помилка! Такої поверхні не існує. Хочаб один коефіцієнт має не дорівнювати 0.");
        return "index";
    }
}