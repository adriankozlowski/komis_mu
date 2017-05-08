package pl.quider.web.komis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.quider.web.komis.services.AgreementService;
import pl.quider.web.komis.services.ReportService;

/**
 * Created by adrian on 08.05.17.
 */
@Controller
@RequestMapping("/report")
public class ReportController
{

    @Autowired
    private ReportService reportService;
    @Autowired
    private AgreementService agreementService;

    @GetMapping("/generateReport")
    public String generateReportWizardStart(ModelMap modelMap){

        modelMap.addAttribute("agreements", agreementService.getTypes());
        return "reports/addNew";
    }
}
