package pl.quider.web.komis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.quider.web.komis.dtos.CarOfferDto;
import pl.quider.web.komis.services.UserService;

import java.util.List;

/**
 * Created by adrian on 04.05.17.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public String showIndex(ModelMap modelMap) {

        modelMap.addAttribute("users", userService.getAll());
        return "users/list";
    }
}
