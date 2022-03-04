
import java.awt.*;
import javax.swing.JFrame;

/**
 * the main frame for the application. The other parts will be layered on top of
 * this frame.
 */
public class CalculatorFrame extends JFrame {
    private ICalculator m_engine;
    private CalculatorMemory m_memory;
    private CalculatorMainDisplayPanel m_displayTextPanel;
    private CalculatorNumberPanel m_numbers;
    private CalculatorRightSidePanel m_rightSide;
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public CalculatorFrame(ICalculator engine) {
        m_engine = engine;
        m_memory = new CalculatorMemory();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(new BorderLayout());
        // set the size here.
        setSize(400, 400);
        Dimension d = new Dimension(400, 400);
        setPreferredSize(d);
        m_displayTextPanel = new CalculatorMainDisplayPanel(this);
        add(m_displayTextPanel, BorderLayout.NORTH);

        m_numbers = new CalculatorNumberPanel(this);
        add(m_numbers, BorderLayout.CENTER);

        m_rightSide = new CalculatorRightSidePanel(this);
        add(m_rightSide, BorderLayout.EAST);

        pack();
        setVisible(true);
    }

    public ICalculator getEngine() {
        return m_engine;
    }

    public CalculatorMemory getMemory() {
        return m_memory;
    }

    public void setDisplayValue(String value) {
        m_displayTextPanel.setDisplay(value);
    }

    public String getDisplayValue() {
        return m_displayTextPanel.getDisplay();
    }

    public void clearDisplay() {
        m_displayTextPanel.clearDisplay();
    }
}
