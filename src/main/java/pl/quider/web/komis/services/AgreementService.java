package pl.quider.web.komis.services;

import org.modelmapper.ModelMapper;
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
        ModelMapper modelMapper = new ModelMapper();
        AgreementDto agreementDto = modelMapper.map(agreement, AgreementDto.class);
        return agreementDto;
    }
}
