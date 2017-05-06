package pl.quider.web.komis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.quider.web.komis.dtos.InvoiceDto;
import pl.quider.web.komis.models.Invoice;
import pl.quider.web.komis.services.InvoiceService;

import java.util.List;

/**
 * Created by adrian on 04.05.17.
 */
@Controller
@RequestMapping("/invoices")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @GetMapping("/list")
    public String showList(ModelMap modelMap){

        List<InvoiceDto> invoices = invoiceService.getAllInvoices();
        modelMap.addAttribute("invoices",invoices);

        return "invoices/list";
    }
}
