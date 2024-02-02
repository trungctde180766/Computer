package controller;

import model.CalculatorModel;
import view.CalculatorView;

public class CalculatorController {
    private CalculatorView view;
    private CalculatorModel model;

    public CalculatorController(CalculatorView view, CalculatorModel model) {
        this.view = view;
        this.model = model;
    }

    public void processMenuOption(int option) {
        switch (option) {
            case 1:
                normalCalculator();
                break;
            case 2:
                bmiCalculator();
                break;
            case 3:
                view.displayMessage("Exiting program...");
                System.exit(0);
                break;
            default:
                view.displayMessage("Invalid option. Please try again.");
        }
    }

    private void normalCalculator() {
        double memory = view.inputNumber("Enter number: ");
        while (true) {
            String operator = view.inputOperator();
            if (operator.equalsIgnoreCase("=")) {
                view.displayResult(memory);
                return;
            }
            double operand = view.inputNumber("Enter number: ");
            memory = model.calculate(memory, operator, operand);
            view.displayMessage("Memory: " + memory);
        }
    }

    private void bmiCalculator() {
        double weight = view.inputNumber("Enter Weight (kg): ");
        double height = view.inputNumber("Enter Height (cm): ");
        double bmi = model.calculateBMI(weight, height); 
        view.displayBMIStatus(bmi);
    }
}
