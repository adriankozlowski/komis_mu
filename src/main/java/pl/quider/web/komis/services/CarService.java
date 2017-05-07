package pl.quider.web.komis.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pl.quider.web.komis.dtos.CarDetailsDto;
import pl.quider.web.komis.dtos.NewCarFormDto;
import pl.quider.web.komis.models.Car;
import pl.quider.web.komis.models.Fuel;
import pl.quider.web.komis.models.Person;
import pl.quider.web.komis.models.Transmission;
import pl.quider.web.komis.repositories.CarRepository;
import pl.quider.web.komis.repositories.FuelRepository;
import pl.quider.web.komis.repositories.TransmissionRepository;

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
    @Qualifier("transmissionRepository")
    @Autowired
    private TransmissionRepository transmissionRepository;


    /**
     *
     * @param carDto
     * @return
     */
    @Transactional
    public Car saveCar(NewCarFormDto carDto) {
        Person person = personService.add(carDto);
        Fuel fuelType = fuelRepository.findOne(carDto.getFuelType());
        Transmission transmission = transmissionRepository.findOne(carDto.getTransmission());
        Car car = new Car();
        car.setDistance(carDto.getDistance());
        car.setYear(carDto.getYear());
        car.setEngine(carDto.getEngince());
        car.setManufacturer(carDto.getManufacturer());
        car.setModel(carDto.getModel());
        car.setOwner(person);
        car.setFuel(fuelType);
        car.setTransmission(transmission);


        carRepository.save(car);

        return car;
    }

    public CarDetailsDto getCarDetails(Integer id) {
        Car car = carRepository.findOne(id);
        ModelMapper modelMapper = new ModelMapper();
        CarDetailsDto carDto = modelMapper.map(car, CarDetailsDto.class);
        return carDto;
    }
}
