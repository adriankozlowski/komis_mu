package pl.quider.web.komis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.quider.web.komis.dtos.NewCarFormDto;
import pl.quider.web.komis.models.Car;
import pl.quider.web.komis.models.Fuel;
import pl.quider.web.komis.models.Person;
import pl.quider.web.komis.repositories.CarRepository;
import pl.quider.web.komis.repositories.FuelRepository;

import javax.transaction.Transactional;

/**
 * Created by adrian on 06.05.17.
 */
@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;
    @Autowired
    private PersonService personService;
    
    @Autowired
    private FuelRepository fuelRepository;

    /**
     *
     * @param carDto
     * @return
     */
    @Transactional
    public Car saveCar(NewCarFormDto carDto) {
        Person person = personService.add(carDto);
        Fuel fuelType = fuelRepository.findOne(carDto.getFuelType());
        Car car = new Car();
        car.setDistance(carDto.getDistance());
        car.setYear(carDto.getYear());
        car.setEngine(carDto.getEngince());
        car.setManufacturer(carDto.getManufacturer());
        car.setModel(carDto.getModel());
        car.setOwner(person);
        car.setFuel(fuelType);

        carRepository.save(car);

        return car;
    }
}
