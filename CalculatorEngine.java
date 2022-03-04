
/**
 * the implementation of the calcultor engine
 *
 * @summary short description for the file
 * @author Ifeanyi Ibeanusi
 *
 * Created at     : 2021-03-30 20:43:45 
 * Last modified  : 2021-03-30 20:44:08
 */

import java.util.ArrayList;

/**
 * This class implements the ICalculator interface. To add Calculator functions:
 * 1 update the arraylist of operations in the constructor 2 add the operation
 * to the doOperations switch statement 3 implement the operation.
 */
public class CalculatorEngine implements ICalculator {
    private ArrayList<IOperation> m_operations;

    public CalculatorEngine() {
        m_operations = new ArrayList<IOperation>();

        IOperation op = new CalculatorOperation();
        op.setOperation("+");
        m_operations.add(op);

        op = new CalculatorOperation();
        op.setOperation("-");
        m_operations.add(op);

        op = new CalculatorOperation();
        op.setOperation("/");
        m_operations.add(op);

        op = new CalculatorOperation();
        op.setOperation("*");
        m_operations.add(op);

        op = new CalculatorOperation();
        op.setOperation("^");
        m_operations.add(op);

        op = new CalculatorOperation();
        op.setOperation("%");
        m_operations.add(op);

        op = new CalculatorOperation();
        op.setOperation("e");
        m_operations.add(op);
    }

    @Override
    public ArrayList<IOperation> getOperations() {
        return m_operations;
    }

    @Override
    public ICalculatorAnswer doOperation(IOperation op, ArrayList<IOperand> operands) {
        IOperand ans = new CalculatorOperand();
        ICalculatorAnswer calcAns = new CalculatorAnswer();
        switch (op.getOperation()) {
        case "+":
        case "add": {
            ans = add((operands.get(0)), operands.get(1));
            break;
        }
        case "-":
        case "sub": {
            ans = subtract(operands.get(0), operands.get(1));
            break;
        }
        case "/":
        case "div": {
            ans = divide(operands.get(0), operands.get(1));
            break;
        }
        case "*":
        case "multiply": {
            ans = multiply(operands.get(0), operands.get(1));
            break;
        }
        case "^":
        case "pow": {
            ans = power(operands.get(0), operands.get(1));
            break;
        }
        case "%":
        case "mod": {
            ans = mod(operands.get(0), operands.get(1));
            break;
        }

        case "e":
        case "exp": {
            ans = exp(operands.get(0));
            break;
        }

        }
        calcAns.setAnswer(ans.getType(), ans);
        return calcAns;
    }

    /**
     * 
     * @param op1
     * @param op2
     * @return
     */
    private IOperand mod(IOperand op1, IOperand op2) {
        IOperand opAnswer = new CalculatorOperand();
        switch (op1.getType()) {
        case ("int"): {
            opAnswer.setValue("int", 0.0, op1.getInt() % op2.getInt());
            break;
        }
        case ("double"): {
            opAnswer.setValue("double", op1.getDouble() % op2.getDouble(), 0);
            break;
        }
        }
        return opAnswer;
    }

    /**
     * This is the Addition operation.
     * 
     * @param op1 the first number to add
     * @param op2 the second number to add
     * @return the result of adding one and two.
     */
    private IOperand add(IOperand op1, IOperand op2) {
        IOperand opAnswer = new CalculatorOperand();
        switch (op1.getType()) {
        case ("int"): {
            opAnswer.setValue("int", 0.0, op1.getInt() + op2.getInt());
            break;
        }
        case ("double"): {
            opAnswer.setValue("double", op1.getDouble() + op2.getDouble(), 0);
            break;
        }
        }
        return opAnswer;
    }

    /**
     * implement the operations.
     * 
     * @param op1 the first operand
     * @param op2 the second operand
     * @return op1 - op2
     */
    private IOperand subtract(IOperand op1, IOperand op2) {
        IOperand opAnswer = new CalculatorOperand();
        switch (op1.getType()) {
        case ("int"): {
            opAnswer.setValue("int", 0, op1.getInt() - op2.getInt());
            break;
        }
        case ("double"): {
            opAnswer.setValue("double", op1.getDouble() - op2.getDouble(), 0);
            break;
        }
        }
        return opAnswer;
    }

    private IOperand divide(IOperand op1, IOperand op2) {
        IOperand opAnswer = new CalculatorOperand();
        switch (op1.getType()) {
        case ("int"): {
            opAnswer.setValue("int", 0, op1.getInt() / op2.getInt());
            break;
        }
        case ("double"): {
            opAnswer.setValue("double", op1.getDouble() / op2.getDouble(), 0);
            break;
        }
        }
        return opAnswer;
    }

    private IOperand multiply(IOperand op1, IOperand op2) {
        IOperand opAnswer = new CalculatorOperand();
        switch (op1.getType()) {
        case ("int"): {
            opAnswer.setValue("int", 0, op1.getInt() * op2.getInt());
            break;
        }
        case ("double"): {
            opAnswer.setValue("double", op1.getDouble() * op2.getDouble(), 0);
            break;
        }
        }
        return opAnswer;
    }

    /**
     * raise op1 to the op2 power.
     * 
     * @param op1 - the base value
     * @param op2 - the power to apply
     * @return base raised to the power
     */
    private IOperand power(IOperand op1, IOperand op2) {
        IOperand opAnswer = new CalculatorOperand();
        switch (op1.getType()) {
        case ("int"): {
            opAnswer.setValue("int", 0.0, (int) Math.pow(op1.getInt(), op2.getInt()));
            break;
        }
        case ("double"): {
            opAnswer.setValue("double", Math.pow(op1.getDouble(), op2.getDouble()), 0);
            break;
        }
        }
        return opAnswer;
    }

    private IOperand exp(IOperand op1) {
        IOperand opAnswer = new CalculatorOperand();
        switch (op1.getType()) {
        case ("int"): {
            opAnswer.setValue("int", 0.0, (int) Math.exp(op1.getInt()));
            break;
        }
        case ("double"): {
            opAnswer.setValue("double", Math.exp(op1.getDouble()), 0);
            break;
        }
        }
        return opAnswer;
    }
    /*
     * public IOperand decimal(IOperand op1) { IOperand opAnswer = new
     * CalculatorOperand(); case ("int"): { opAnswer.setvalue("int", 0.0, (int) ) }
     * }
     */

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("The operations are : \n");
        for (IOperation iOperation : m_operations) {
            sb.append(iOperation.getOperation() + "\n");
        }
        return sb.toString();
    }
}
