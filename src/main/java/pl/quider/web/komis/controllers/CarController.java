package pl.quider.web.komis.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.quider.web.komis.dtos.CarOfferDto;
import pl.quider.web.komis.dtos.NewCarFormDto;
import pl.quider.web.komis.models.Car;
import pl.quider.web.komis.repositories.FuelRepository;
import pl.quider.web.komis.repositories.TransmissionRepository;
import pl.quider.web.komis.services.CarService;
import pl.quider.web.komis.services.ImageService;
import pl.quider.web.komis.services.OfferService;

import javax.imageio.stream.FileImageOutputStream;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by adrian on 04.05.17.
 */
@Controller
@RequestMapping("/car")
public class CarController {

    Logger log = LoggerFactory.getLogger(CarController.class);

    public static final String SELL = "Sprzedaż";
    public static final String CESSION = "Cesja";
    public static final int CESSION_AGREEMENT_ID = 2;
    public static final int SELL_AGREEMENT_ID = 3;
    public static final String CAR_LIST = "carList";
    public static final String MAIN_PAGE_CAR_LIST = "mainPage/carList";
    public static final String CARS_ADD = "cars/add";
    public static final String REDIRECT_TO_ROOT = "redirect:/";
    public static final String AGREEMENTS_LIST = "agreements/list";
    public static final String AGREEMENTS = "agreements";
    public static final String CAR_DTO = "carDto";
    public static final String TRANSMISSIONS = "transmissions";
    public static final String AGREEMENT_TYPE_ID = "agreementTypeId";
    public static final String FUELS = "fuels";
    public static final String AGREEMENT_TYPE = "agreementType";

    @Autowired
    private OfferService offerService;

    @Autowired
    private CarService carService;

    @Autowired
    private FuelRepository fuelRepository;

    @Qualifier("transmissionRepository")
    @Autowired
    private TransmissionRepository transmissionRepository;

    @Autowired
    private ImageService imageService;


    /**
     * @param modelMap
     * @return
     */
    @GetMapping("/toSell")
    public String showIndex(ModelMap modelMap) {
        List<CarOfferDto> list = offerService.getReadyToSellCars();
        modelMap.addAttribute(CAR_LIST, list);
        return MAIN_PAGE_CAR_LIST;
    }

    /**
     * @param modelMap
     * @return
     */
    @GetMapping("/purchase")
    public String showAddForm(ModelMap modelMap) {
        NewCarFormDto newCarFormDto = new NewCarFormDto();
        newCarDropdowns(modelMap, newCarFormDto, SELL, SELL_AGREEMENT_ID);
        return CARS_ADD;
    }

    /**
     * @param modelMap
     * @param newCarFormDto
     */
    private void newCarDropdowns(ModelMap modelMap, NewCarFormDto newCarFormDto, String value, Integer agreementType) {
        modelMap.addAttribute(AGREEMENT_TYPE, value);
        modelMap.addAttribute(FUELS, fuelRepository.findAll());
        modelMap.addAttribute(AGREEMENT_TYPE_ID, agreementType);
        modelMap.addAttribute(TRANSMISSIONS, transmissionRepository.findAll());
        modelMap.addAttribute(CAR_DTO, newCarFormDto);
    }

    /**
     * @param file
     * @param carDto
     * @param bindingResult
     * @param modelMap
     * @return
     */
    @PostMapping("/add")
    @Transactional
    public String saveCar(@RequestPart(value = "image", required = false) MultipartFile file,
                          @Valid @ModelAttribute("carDto") NewCarFormDto carDto,
                          BindingResult bindingResult,
                          ModelMap modelMap) {
        if (bindingResult.hasErrors()) {
            modelMap.addAttribute(carDto);
            this.newCarDropdowns(modelMap, carDto, carDto.getAgreementTypeId() == 3 ? SELL : CESSION, carDto.getAgreementTypeId());
            return CARS_ADD;
        }

        Car car = carService.saveCar(carDto);
        imageService.saveImage(file,car);

        offerService.createOffer(car, carDto.getAgreementTypeId(), carDto.getAmount());
        return REDIRECT_TO_ROOT;
    }

    /**
     * @param modelMap
     * @return
     */
    @GetMapping("/cession")
    public String showCessionAddForm(ModelMap modelMap) {
        NewCarFormDto newCarFormDto = new NewCarFormDto();
        newCarDropdowns(modelMap, newCarFormDto, CESSION, CESSION_AGREEMENT_ID);
        return CARS_ADD;
    }

    /**
     * @param modelMap
     * @return
     */
    @GetMapping("/sold")
    public String showSoldList(ModelMap modelMap) {

        List<CarOfferDto> agreements = offerService.getSoldCars();
        modelMap.addAttribute(AGREEMENTS, agreements);

        return AGREEMENTS_LIST;
    }

    @GetMapping("/details/{id}")
    public String showDetails(@PathVariable Integer id, ModelMap modelMap) {
        modelMap.addAttribute("carDto", carService.getCarDetails(id));
        return "cars/details";
    }

}
