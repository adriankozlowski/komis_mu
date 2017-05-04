package pl.quider.web.komis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.quider.web.komis.dtos.CarOfferDto;
import pl.quider.web.komis.services.OfferService;

import java.util.List;

/**
 * Created by adrian on 04.05.17.
 */
@Controller
@RequestMapping("/car")
public class CarController {

    @Autowired
    private OfferService offerService;

    @GetMapping("/")
    public String showIndex(ModelMap modelMap){
        List<CarOfferDto> list =  offerService.getReadyToSellCars();
        modelMap.addAttribute("carList", list );
        return "mainPage/carList";
    }
}
