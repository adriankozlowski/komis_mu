package pl.quider.web.komis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.quider.web.komis.dtos.CarOfferDto;
import pl.quider.web.komis.models.Agreement;
import pl.quider.web.komis.models.AgreementType;
import pl.quider.web.komis.models.Car;
import pl.quider.web.komis.repositories.AgreementRepository;
import pl.quider.web.komis.repositories.AgreementTypeRepository;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
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
    @Autowired
    private InvoiceService invoiceService;

    /**
     *
     * @return
     */
    public List<CarOfferDto> getReadyToSellCars() {
        AgreementType purchaseType = agreementTypeRepository.getOne(3); // in table id 3 = purchase
        List<Agreement> agreements = agreementRepository.findAllByAgreementType(purchaseType);
        List<CarOfferDto> purchases = agreements.stream().map(OfferService::agreementToSellOffer).collect(Collectors.toList());

        AgreementType cessionType = agreementTypeRepository.getOne(2); // in table id 2 = cession
        agreements = agreementRepository.findAllByAgreementType(cessionType);
        List<CarOfferDto> cessions = agreements
                .stream()
                .map(OfferService::agreementToSellOffer)
                .collect(Collectors.toList());


        List<CarOfferDto> collect = new ArrayList<>(purchases);
        collect.addAll(cessions);
        Iterator<CarOfferDto> iterator = collect.iterator();
        while(iterator.hasNext()){
            CarOfferDto offer = iterator.next();

            Integer integer = agreementRepository.countAllByCarId(offer.getId());
            if(!integer.equals(1)){
                iterator.remove();
            }
        }

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
        carOfferDto.setId(car.getId());
        carOfferDto.setDistance(car.getDistance());
        carOfferDto.setEngine(car.getEngine());
        carOfferDto.setFuelType(car.getFuel().getName());
        carOfferDto.setManufacturer(car.getManufacturer());
        carOfferDto.setModel(car.getModel());
        carOfferDto.setYear(car.getYear());
        carOfferDto.setAmount(agreement.getAmount());
        return carOfferDto;
    }

    @Transactional
    public Agreement createOffer(Car car, Integer agreementTypeId, BigDecimal amount) {
        AgreementType one = agreementTypeRepository.findOne(agreementTypeId);
        Agreement agreement = new Agreement();
        agreement.setAgreementType(one);
        agreement.setAmount(amount);
        agreement.setCar(car);
        agreement.setDate(new Date());
        agreement.setContent("Sprzedaz samochodu :D:D:D:D:D:DD:");
        agreement.setPerson(agreement.getCar().getOwner());

        Agreement saved = agreementRepository.save(agreement);

        invoiceService.createInvoice(saved);

        return saved;
    }

    public List<CarOfferDto> getSoldCars() {
        AgreementType sellType = agreementTypeRepository.getOne(1); // in table id 3 = sell
        List<Agreement> allByAgreementType = agreementRepository.findAllByAgreementType(sellType);
        List<CarOfferDto> purchases = allByAgreementType.stream().map(OfferService::agreementToSellOffer).collect(Collectors.toList());
        return purchases;
    }
}
