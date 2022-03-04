

import java.awt.Font;

import javax.swing.JButton;

/**
 * the class that implemnts the UI for the operation button. The button will
 * have the actionlistener to send the text to the "registers."
 */
public class CalculatorOperationButton extends JButton {
    private String m_operation;
    private CalculatorOperationPanel m_parent;
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * the constructor for the button. It implements the actionlistener as a lambda
     * function.
     * 
     * @param parent the frame that holds the button.
     * @param value  the operation that the button calls.
     */
    public CalculatorOperationButton(CalculatorOperationPanel parent, String value) {
        m_operation = value;
        m_parent = parent;
        // lots of crazy code to make the button text stand out.
        setFont(new Font(getFont().getName(), getFont().getStyle(), getFont().getSize() * 3));

        setText(value);

        this.addActionListener(e -> {
            CalculatorOperationButton btn = (CalculatorOperationButton) e.getSource();
            // get the parent and call the reset.
            System.out.println("hit button value is " + btn.getOperation());
            // get the operation
            String btnVal = btn.getText();
            String regOneVal = m_parent.getCalculatorFrame().getMemory().getRegisterOne();
            m_parent.getCalculatorFrame().getMemory().setRegisterTwo(regOneVal);
            m_parent.getCalculatorFrame().getMemory().setRegisterOne("");
            m_parent.getCalculatorFrame().clearDisplay();
            m_parent.getCalculatorFrame().getMemory().setOperation(btnVal);
            // move registerone over to two and store the operations.
        });
    }

    /**
     * gets the operation that is connected to this button.
     * 
     * @return
     */
    public String getOperation() {
        return m_operation;
    }
}
