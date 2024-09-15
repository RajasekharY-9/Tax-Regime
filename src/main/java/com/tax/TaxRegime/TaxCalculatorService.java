package com.tax.TaxRegime;

import org.springframework.stereotype.Service;

@Service
public class TaxCalculatorService {
    
    public double calculateTax(double salary) {
        double standardDeduction = 75000;
        double taxableIncome = salary - standardDeduction;
        double tax;

        if (taxableIncome <= 250000) {
            tax = 0;
        } else if (taxableIncome <= 500000) {
            tax = (taxableIncome - 250000) * 0.05;
        } else if (taxableIncome <= 1000000) {
            tax = 12500 + (taxableIncome - 500000) * 0.10;
        } else {
            tax = 62500 + (taxableIncome - 1000000) * 0.15;
        }

        return tax;
    }

    public double calculateMonthlyTakeHome(double salary, double tax) {
        return (salary - tax) / 15;
    }
}
