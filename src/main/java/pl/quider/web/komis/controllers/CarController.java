package pl.quider.web.komis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.quider.web.komis.dtos.CarOfferDto;
import pl.quider.web.komis.dtos.NewCarFormDto;
import pl.quider.web.komis.models.Car;
import pl.quider.web.komis.repositories.FuelRepository;
import pl.quider.web.komis.services.CarService;
import pl.quider.web.komis.services.OfferService;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by adrian on 04.05.17.
 */
@Controller
@RequestMapping("/car")
public class CarController {

    @Autowired
    private OfferService offerService;

    @Autowired
    private CarService carService;

    @Autowired
    private FuelRepository fuelRepository;

    @GetMapping("/toSell")
    public String showIndex(ModelMap modelMap){
        List<CarOfferDto> list =  offerService.getReadyToSellCars();
        modelMap.addAttribute("carList", list );
        return "mainPage/carList";
    }

    @GetMapping("/purchase")
    public String showAddForm(ModelMap modelMap){
        NewCarFormDto newCarFormDto = new NewCarFormDto();
        modelMap.addAttribute("agreementType","Sprzedaż");
        modelMap.addAttribute("fuels", fuelRepository.findAll());
        modelMap.addAttribute("agreementTypeId", 3);
        modelMap.addAttribute("carDto", newCarFormDto );
        return "cars/add";
    }

    @PostMapping("/add")
    @Transactional
    public String saveCar(@RequestPart(value = "image", required = false) MultipartFile file, @ModelAttribute NewCarFormDto carDto, ModelMap modelMap){
        Car car = carService.saveCar(carDto);
        offerService.createOffer(car, carDto.getAgreementTypeId(), carDto.getAmount());
        return "redirect:/";
    }

    @GetMapping("/cession")
    public String showCessionAddForm(ModelMap modelMap){
        NewCarFormDto newCarFormDto = new NewCarFormDto();
        modelMap.addAttribute("fuels", fuelRepository.findAll());
        modelMap.addAttribute("agreementTypeId", 2);
        modelMap.addAttribute("agreementType","Cesja");
        modelMap.addAttribute("carDto", newCarFormDto );
        return "cars/add";
    }

    @GetMapping("/sold")
    public String showSoldList(ModelMap modelMap){

        List<CarOfferDto> agreements = offerService.getSoldCars();
        modelMap.addAttribute("agreements",agreements);

        return "agreements/list";
    }


}
