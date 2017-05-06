package pl.quider.web.komis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.quider.web.komis.dtos.PersonDto;
import pl.quider.web.komis.services.PersonService;

import java.util.List;

/**
 * Created by adrian on 04.05.17.
 */
@Controller
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/list")
    public String showList(ModelMap modelMap){
        List<PersonDto> personDtoList = personService.getAllPersons();
        modelMap.addAttribute("persons", personDtoList);
        return "persons/list";
    }
}
