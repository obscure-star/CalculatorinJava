
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;

/**
 * the clas that implements the number buttons. These will need to pass the
 * value on to the text field. There are two special cases in here. one for the
 * clear button and one for the equals button. They are in here to make things
 * easy.
 */
public class CalculatorButton extends JButton {
    private double m_value;
    private CalculatorNumberPanel m_parent;
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * The constructor. it implements the actionlistener as a lambda function.
     * 
     * @param parent
     * @param value
     */
    public CalculatorButton(CalculatorNumberPanel parent, int value) {
        m_value = value;
        m_parent = parent;

        setFont(new Font(getFont().getName(), getFont().getStyle(), getFont().getSize() * 3));
        if (value == -1)
            this.setText("C");
        else if (value == -2)
            this.setText("=");
        else
            this.setText(String.valueOf(value));

        this.addActionListener(e -> {
            CalculatorButton btn = (CalculatorButton) e.getSource();
            // get the parent and call the reset.
            System.out.println("hit button value is " + btn.getValue());
            String btnValue = btn.getText();
            if (btnValue.equals("C")) {
                m_parent.getParentCalculatorFrame().getMemory().clearRegister("1");
                ;
                m_parent.getParentCalculatorFrame().setDisplayValue("");
                m_parent.getParentCalculatorFrame().clearDisplay();
            } // if the button is an = then you need to get the two registers and call the
              // operation.
            else if (btnValue.equals("=")) {
                String valOne = m_parent.getParentCalculatorFrame().getMemory().getRegisterTwo();
                String valTwo = m_parent.getParentCalculatorFrame().getMemory().getRegisterOne();
                String opname = m_parent.getParentCalculatorFrame().getMemory().getOperation().getOperation();

                CalculatorOperation oper = new CalculatorOperation();
                oper.setOperation(opname);

                CalculatorOperand oprnd = new CalculatorOperand();
                ArrayList<IOperand> operands = new ArrayList<IOperand>();
                oprnd.setValue("double", Double.parseDouble(valOne), 0);
                operands.add(oprnd);
                oprnd = new CalculatorOperand();
                oprnd.setValue("double", Double.parseDouble(valTwo), 0);
                operands.add(oprnd);

                ICalculatorAnswer ans = m_parent.getParentCalculatorFrame().getEngine().doOperation(oper, operands);

                String ansString = String.valueOf(ans.getAnswer().getDouble());
                m_parent.getParentCalculatorFrame().getMemory().clearRegister("1");
                m_parent.getParentCalculatorFrame().getMemory().setRegisterOne(ansString);
                m_parent.getParentCalculatorFrame().setDisplayValue(ansString);
            } else {
                m_parent.getParentCalculatorFrame().getMemory().setRegisterOne(String.valueOf(btn.getValue()));
                String val = m_parent.getParentCalculatorFrame().getMemory().getRegisterOne();
                m_parent.getParentCalculatorFrame().setDisplayValue(val);
            }
        });
    }

    /**
     * get the value attached to the button.
     * 
     * @return
     */
    public Double getValue() {
        return m_value;
    }
}
