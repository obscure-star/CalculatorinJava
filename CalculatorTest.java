
/**
 * A test application for a calculator.
 *
 * @summary short description for the file
 * @author Ifeanyi Ibeanusi
 *
 * Created at     : 2021-03-30 20:44:55 
 * Last modified  : 2021-03-30 20:45:12
 */

/**
 * Changes made:
 * Double value shown in text display
 * Exponent button provided
 */

import java.util.ArrayList;
import java.util.Scanner;

public class CalculatorTest {
    /**
     * lists out the operations available
     * 
     * @param calcEngine
     */
    private static void ListOperations(ICalculator calcEngine) {
        System.out.println(calcEngine.toString());
    }

    /**
     * the main entry point for the test application.
     * 
     * @param args
     */
    public static void main(String[] args) {
        ICalculator calc = new CalculatorEngine();

        Scanner ioOps = new Scanner(System.in);
        String op = "";
        ArrayList<IOperand> operands = new ArrayList<IOperand>();
        IOperand operand = new CalculatorOperand();
        IOperation operation = new CalculatorOperation();

        CalculatorFrame calcUI = new CalculatorFrame(calc);

        // this tests the operations...
        do {
            System.out.print("enter operation L for list of available: ");
            op = ioOps.nextLine();
            switch (op) {
            case "L": {
                ListOperations(calc);
                break;
            }
            case "+":
            case "-":
            case "/":
            case "*":
            case "^":
            case "%": {
                operation.setOperation(op);
                break;
            }
            case "e":
            case "=": {
                // this is where to run the operation.
                if ((operands.size() == 2) && (operand.isSet())) {
                    ICalculatorAnswer a = calc.doOperation(operation, operands);
                    System.out.println("the answer is :" + a.getAnswer().toString());
                    // clear out the operands
                    operands = new ArrayList<IOperand>();
                }
            }
            default: {
                try {
                    int x = Integer.parseInt(op);
                    operand = new CalculatorOperand();
                    operand.setValue("int", 0, x);
                    operands.add(operand);
                } catch (NumberFormatException e) {
                    try {
                        double d = Double.parseDouble(op);
                        operand = new CalculatorOperand();
                        operand.setValue("double", d, 0);
                    } catch (NumberFormatException ne) {

                    }
                }
            }
            }
        } while (!op.equalsIgnoreCase("Q"));
        ioOps.close();

    }
}
