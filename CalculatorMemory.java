
import java.util.Stack;

/**
 * implementation of a simple memory organization.
 */
public class CalculatorMemory {
    private Stack<IOperand> m_stack; // for the future.
    private IOperand m_registerOne;
    private IOperand m_registerTwo;
    private IOperation m_lastOp;

    public CalculatorMemory() {
        m_stack = new Stack<IOperand>();
        m_registerOne = new CalculatorOperand();
        m_registerTwo = new CalculatorOperand();
        m_lastOp = new CalculatorOperation();
    }

    public void clearRegister(String regID) {
        if (regID == "1")
            m_registerOne = new CalculatorOperand();
        else
            m_registerTwo = new CalculatorOperand();
    }

    /**
     * builds the number in the text field.
     * 
     * @param value the digit to append to the field.
     */
    public void setRegisterOne(String value) {
        if (value.length() == 0) {
            clearRegister("1");
            return;
        }
        StringBuffer val = new StringBuffer(String.valueOf(m_registerOne.getDouble()));
        val.append(value);
        if (val.substring(0, 3).equals("0.0")) {
            val.delete(0, 3);
        } else if (val.substring(val.length() - 3, val.length() - 1).equals(".0")) {
            val.delete(val.length() - 3, val.length() - 1);
        }
        m_registerOne.setValue("double", Double.parseDouble(val.toString()), 0);
    }

    /**
     * gets the string value that is in the register.
     * 
     * @return
     */
    public String getRegisterOne() {
        String rtnString = String.valueOf(m_registerOne.getDouble());
        return rtnString;
    }

    /**
     * hold the "other" value to be worked with.
     * 
     * @param registerOneValue
     */
    public void setRegisterTwo(String registerOneValue) {
        if (registerOneValue.length() == 0) {
            clearRegister("2");
            return;
        }

        m_registerTwo.setValue("double", Double.parseDouble(registerOneValue), 0);
    }

    /**
     * get the operation that is in "memory"
     * 
     * @return
     */
    public String getRegisterTwo() {
        return String.valueOf(m_registerTwo.getDouble());
    }

    /**
     * set the operation to store
     * 
     * @param opValue
     */
    public void setOperation(String opValue) {
        m_lastOp.setOperation(opValue);
    }

    /**
     * get the operation that is stored.
     * 
     * @return
     */
    public IOperation getOperation() {
        return m_lastOp;
    }
}
