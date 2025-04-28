package losky2987.AirportInfoDisplay.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RouterController {
    @GetMapping("/test")
    public String test(Model model) {
        model.addAttribute("gate", "D01");
        return "gate";
    }
}
