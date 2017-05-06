package pl.quider.web.komis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.quider.web.komis.dtos.AgreementDto;
import pl.quider.web.komis.models.Agreement;
import pl.quider.web.komis.repositories.AgreementRepository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by adrian on 06.05.17.
 */
@Service
public class AgreementService {
    @Autowired
    AgreementRepository agreementRepository;

    public List<AgreementDto> getAllAgreements() {
        return agreementRepository.findAll().stream().map(this::mapAgreements).collect(Collectors.toList());
    }

    private  AgreementDto mapAgreements(Agreement agreement) {
        AgreementDto agreementDto = new AgreementDto(
                agreement.getId(),
                agreement.getAmount(),
                agreement.getCar().getManufacturer(),
                agreement.getCar().getModel(),
                agreement.getPerson().getName(),
                agreement.getPerson().getSurname(),
                agreement.getDate()
        );
        return agreementDto;
    }
}
