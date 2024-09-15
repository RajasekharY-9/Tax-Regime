package com.tax.TaxRegime;

//import com.example.taxcalculator.service.TaxCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TaxCalculatorController {

    @Autowired
    private TaxCalculatorService taxCalculatorService;

    @GetMapping("/")
    public String showForm() {
        return "index";
    }

    @PostMapping("/calculate")
    public String calculateTax(@RequestParam("salary") double salary, Model model) {
        double tax = taxCalculatorService.calculateTax(salary);
        double monthlyTakeHome = taxCalculatorService.calculateMonthlyTakeHome(salary, tax);
        double standardDeduction = 75000;
        double taxableIncome = salary - standardDeduction;

        model.addAttribute("salary", salary);
        model.addAttribute("standardDeduction", standardDeduction);
        model.addAttribute("taxableIncome", taxableIncome);
        model.addAttribute("tax", tax);
        model.addAttribute("monthlyTakeHome", monthlyTakeHome);

        return "result";
    }
}
