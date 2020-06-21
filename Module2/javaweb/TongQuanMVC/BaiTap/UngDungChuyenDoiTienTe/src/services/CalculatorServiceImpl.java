package services;

import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorServices{
    @Override
    public double Convert(double num1, double num2) {
        return (num1*num2);
    }
}
