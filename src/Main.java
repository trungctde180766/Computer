
import controller.CalculatorController;
import model.CalculatorModel;
import view.CalculatorView;

public class Main {
    public static void main(String[] args) {
        CalculatorView view = new CalculatorView();
        CalculatorModel model = new CalculatorModel();
        CalculatorController controller = new CalculatorController(view, model);

        int option;
        do {
            option = view.getMenuOption();
            controller.processMenuOption(option);
        } while (option != 3);
    }
}
