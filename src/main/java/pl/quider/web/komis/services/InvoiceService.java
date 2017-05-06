package pl.quider.web.komis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.quider.web.komis.dtos.InvoiceDto;
import pl.quider.web.komis.models.Agreement;
import pl.quider.web.komis.models.Invoice;
import pl.quider.web.komis.repositories.InvoiceRepository;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by adrian on 06.05.17.
 */
@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    /**
     *
     * @param saved
     */
    public void createInvoice(Agreement saved) {
        Invoice invoice = new Invoice();
        invoice.setAdded(new Date());
        invoice.setAgreement(saved);

        invoiceRepository.save(invoice);
    }

    /**
     *
     * @return
     */
    public List<InvoiceDto> getAllInvoices() {
        List<Invoice> all = invoiceRepository.findAll();
        return all.stream().map(this::mapInvoice).collect(Collectors.toList());
    }

    private InvoiceDto mapInvoice(Invoice invoice) {
        InvoiceDto invoiceDto = new InvoiceDto();
        invoiceDto.setManufacturer(invoice.getAgreement().getCar().getManufacturer());
        invoiceDto.setModel(invoice.getAgreement().getCar().getModel());
        invoiceDto.setAmount(invoice.getAgreement().getAmount());
        invoiceDto.setId(invoice.getId());

        return invoiceDto;
    }
}
