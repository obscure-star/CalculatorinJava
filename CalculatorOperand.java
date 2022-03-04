/**
 * the implementation of the calculator operands
 *
 * @summary short description for the file
 * @author Ifeanyi Ibeanusi
 *
 *         Created at : 2021-03-30 20:43:11 Last modified : 2021-03-30 20:43:32
 */

public class CalculatorOperand implements IOperand {
    private String m_operandType;
    private double m_doubleValue;
    private int m_intValue;

    @Override
    public String getType() {
        return m_operandType;
    }

    @Override
    public void setType(String opTypeName) {
        m_operandType = opTypeName;
    }

    @Override
    public double getDouble() {
        return m_doubleValue;
    }

    @Override
    public void setValue(String typeName, double valueD, int valueI) {
        switch (typeName) {
        case ("int"): {
            m_operandType = typeName;
            m_intValue = valueI;
            break;
        }
        case ("double"): {
            m_operandType = typeName;
            m_doubleValue = valueD;
            break;
        }
        default: {
            break;
        }
        }
    }

    @Override
    public int getInt() {
        return m_intValue;
    }

    public String toString() {
        if (m_operandType.equals("double"))
            return Double.toString(m_doubleValue);
        else if (m_operandType.equals("int"))
            return Integer.toString(m_intValue);
        return "NULL";
    }

    @Override
    public boolean isSet() {

        return true;
    }
}
