package losky2987.AirportInfoDisplay.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RouterController {
    @GetMapping("/test")
    public String test(Model model) {
        model.addAttribute("gate", "D01");
        return "gate";
    }

    // below are placeholder, maybe changed in dev progress

    @GetMapping("/gate")
    public String gate(Model model, @RequestParam("gateNumber") String gateNumber) {
        return "gate";
    }

    @GetMapping("/central")
    public String central(Model model, @RequestParam("type") String type) {
        return "central";
    }

    @GetMapping("/admin")
    public String admin(Model model, @RequestParam("id") String id) {
        return "admin";
    }
}
