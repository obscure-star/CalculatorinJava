

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JPanel;



/**
 * the panel that will hold the text that is the display
 */
public class CalculatorMainDisplayPanel extends JPanel {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private CalculatorMainDisplayText m_displayText;
    private CalculatorFrame m_parent;

    public CalculatorMainDisplayPanel(CalculatorFrame parent) {
        m_parent = parent;
        setLayout(new BorderLayout());
        Dimension d = new Dimension(parent.getSize().width, parent.getSize().height / 4);
        setSize(d);
        setPreferredSize(d);
        m_displayText = new CalculatorMainDisplayText(parent);
        add(m_displayText, BorderLayout.CENTER);
    }

    public void setDisplay(String value) {
        m_displayText.setText(value);
    }

    public void clearDisplay() {
        m_displayText.setText("");
    }

    public String getDisplay() {
        return m_displayText.getText();
    }
}