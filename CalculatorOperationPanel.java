
import java.util.ArrayList;
import javax.swing.JPanel;
import java.awt.*;

/**
 * The panel that holds the operation buttons.
 */
public class CalculatorOperationPanel extends JPanel {
    private CalculatorOperationButton[] m_opsButtons;
    private CalculatorFrame m_parent;
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * the constructor of the panel. the operation buttons will be added to a grid
     * that is on this panel.
     */
    public CalculatorOperationPanel(CalculatorFrame parent) {
        m_parent = parent;

        ArrayList<IOperation> ops = m_parent.getEngine().getOperations();
        int opCount = ops.size();// this gets the number of operations that will need buttons.
        setLayout(new GridLayout(4, 1 + opCount % 4)); // set the grid to be four high and x wide
        // make this with integers...
        Dimension d = new Dimension(m_parent.getSize().width / 3, Math.multiplyExact(m_parent.getSize().height, 3 / 4));
        setPreferredSize(d);
        setSize(d);
        m_opsButtons = new CalculatorOperationButton[opCount];
        int i = 0;

        for (IOperation iOperation : ops) {
            String value = iOperation.getOperation();
            m_opsButtons[i] = new CalculatorOperationButton(this, value);
            add(m_opsButtons[i]);
            i++;
        }

    }

    /**
     * gets the parent frame. This is helpful since the panel is hosted on another
     * panel
     * 
     * @return parent frame.
     */
    public CalculatorFrame getCalculatorFrame() {
        return m_parent;
    }
}
