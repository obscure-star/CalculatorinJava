/**
 * the implementation for the calculator engine
 *
 * @summary short description for the file
 * @author Ifeanyi Ibeanusi
 *
 * Created at     : 2021-03-30 20:40:50 
 * Last modified  : 2021-03-30 20:41:13
 */

/**
 * This is the class that implements the set of operations that the calculator
 * can do. The actual mechanics are implemented in the engine. When adding an
 * operation you need to add the KEY to the list in isSet.
 */
public class CalculatorOperation implements IOperation {
    private String m_operation;

    @Override
    public String getOperation() {
        return m_operation;
    }

    @Override
    public void setOperation(String opName) {
        m_operation = opName;
    }

    @Override
    public boolean isSet() {
        String ops = "+-/*^%";
        // String ops = "+-/*^%D";
        return ops.contains(m_operation);
    }

}
