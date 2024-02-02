package view;

import java.util.Scanner;

public class CalculatorView {
    private Scanner scanner = new Scanner(System.in);

    public int getMenuOption() {
        displayMessage("Select an option:");
        displayMessage("1. Normal Calculator");
        displayMessage("2. BMI Calculator");
        displayMessage("3. Exit");
        return getInputIntLimit(1, 3);
    }

    public int getInputIntLimit(int min, int max) {
        while (true) {
            try {
                int result = Integer.parseInt(scanner.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                displayErrorMessage("Please input a number in the range [" + min + ", " + max + "]");
            }
        }
    }

    public double inputNumber(String message) {
        displayMessage(message);
        return getInputDouble();
    }

    public double getInputDouble() {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                displayErrorMessage("Must be a double value");
            }
        }
    }

    public String inputOperator() {
        while (true) {
            displayMessage("Enter operator (+, -, *, /, ^, =):");
            String operator = scanner.nextLine().trim();
            if (operator.isEmpty()) {
                displayErrorMessage("Operator cannot be empty");
            } else if (operator.matches("[+\\-*/^=]")) {
                return operator;
            } else {
                displayErrorMessage("Invalid operator. Please input one of the following: +, -, *, /, ^, =");
            }
        }
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public void displayErrorMessage(String message) {
        System.err.println(message);
    }

    public void displayResult(double result) {
        displayMessage("Result: " + result);
    }

    public void displayBMIStatus(double bmi) {
        String status;
        if (bmi < 19) {
            status = "Under-standard.";
        } else if (bmi >= 19 && bmi < 25) {
            status = "Standard.";
        } else if (bmi >= 25 && bmi < 30) {
            status = "Overweight.";
        } else if (bmi >= 30 && bmi < 40) {
            status = "Fat-should lose weight";
        } else {
            status = "Very fat - should lose weight immediately";
        }
        displayMessage("BMI number: " + bmi);
        displayMessage("BMI Status: " + status);
    }
}
