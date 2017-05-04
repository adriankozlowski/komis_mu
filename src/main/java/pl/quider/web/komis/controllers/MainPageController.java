package pl.quider.web.komis.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by adrian on 04.05.17.
 */

@Controller
public class MainPageController {

    @GetMapping("/")
    public String showIndex(ModelMap modelMap){

        return "layout";
    }

}