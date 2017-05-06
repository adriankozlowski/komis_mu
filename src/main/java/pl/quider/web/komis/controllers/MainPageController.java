package pl.quider.web.komis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import pl.quider.web.komis.services.UserService;

/**
 * Created by adrian on 04.05.17.
 */

@Controller
public class MainPageController {

    @GetMapping("/")
    public String showIndex(ModelMap modelMap){

        return "redirect:/car/toSell";
    }

}