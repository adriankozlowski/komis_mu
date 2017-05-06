package pl.quider.web.komis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.quider.web.komis.dtos.CarOfferDto;
import pl.quider.web.komis.models.Agreement;
import pl.quider.web.komis.models.AgreementType;
import pl.quider.web.komis.models.Car;
import pl.quider.web.komis.repositories.AgreementRepository;
import pl.quider.web.komis.repositories.AgreementTypeRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by adrian on 04.05.17.
 */
@Service
public class OfferService {

    @Autowired
    private AgreementRepository agreementRepository;
    @Autowired
    private AgreementTypeRepository agreementTypeRepository;

    /**
     *
     * @return
     */
    public List<CarOfferDto> getReadyToSellCars() {
        AgreementType purchaseType = agreementTypeRepository.getOne(2); // in table id 3 = purchase
        List<Agreement> agreements = agreementRepository.findAllByAgreementType(purchaseType);
        List<CarOfferDto> collect = agreements.stream().map(OfferService::agreementToSellOffer).collect(Collectors.toList());

        return collect;
    }

    /**
     *
     * @param agreement
     * @return
     */
    private static CarOfferDto agreementToSellOffer(Agreement agreement) {
        Car car = agreement.getCar();
        CarOfferDto carOfferDto = new CarOfferDto();
        carOfferDto.setDistance(car.getDistance());
        carOfferDto.setEngince(car.getEngine());
        carOfferDto.setFuelType(car.getFuel().getName());
        carOfferDto.setManufacturer(car.getManufacturer());
        carOfferDto.setModel(car.getModel());
        carOfferDto.setYear(car.getYear());
        carOfferDto.setAmount(agreement.getAmount());
        return carOfferDto;
    }

    public Agreement createOffer(Car car, Integer agreementTypeId, BigDecimal amount) {
        AgreementType one = agreementTypeRepository.findOne(agreementTypeId);
        Agreement agreement = new Agreement();
        agreement.setAgreementType(one);
        agreement.setAmount(amount);
        agreement.setCar(car);
        agreement.setContent("Sprzedaz samochodu :D:D:D:D:D:DD:");
        agreement.setPerson(agreement.getCar().getOwner());

        agreementRepository.save(agreement);
        return null;
    }
}
