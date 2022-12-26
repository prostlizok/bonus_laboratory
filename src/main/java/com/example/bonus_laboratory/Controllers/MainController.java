package com.example.bonus_laboratory.Controllers;

import com.example.bonus_laboratory.Models.Equation;
import com.example.bonus_laboratory.Repo.EquationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    public static int error_check = 0;

    @Autowired
    private EquationRepository equationRepository;
    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("equation", new Equation());

        if (error_check==1){
            model.addAttribute("error_message", "Помилка! Такої поверхні не існує. Хочаб один коефіцієнт має не дорівнювати 0.");
        }

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
}