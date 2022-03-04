

import java.awt.Font;
import java.awt.image.BufferedImage;
import java.awt.FontMetrics;
import java.lang.Math;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * the text line that is shown at the top of the caclulator
 */
public class CalculatorMainDisplayText extends JTextField {
    private String m_answer;
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * the constructor for the text line.
     * 
     * @param parent
     */
    public CalculatorMainDisplayText(CalculatorFrame parent) {
        setHorizontalAlignment(SwingConstants.RIGHT);
        this.setSize(parent.getSize());
        int fontSize = getFontSize(this, 20);
        setFont(new Font(getFont().getName(), getFont().getStyle(), fontSize));
    }

    /**
     * get the displayed value.
     * 
     * @return
     */
    public String getAnswerText() {
        return m_answer;
    }

    /**
     * the value to display
     * 
     * @param answer
     */
    public void setAnswer(String answer) {
        m_answer = answer;
    }

    /**
     * some crazy code to figure out a size for the text field this will also drive
     * the font size.
     * 
     * @param text          the JTextField to size up.
     * @param columnsToHold the width of the JTextField
     * @return an integer to set the size from.
     */
    public int getFontSize(JTextField text, int columnsToHold) {
        // Create a sample test String (we will it later in our calculations)
        String testString = "";
        for (int i = 0; i < columnsToHold; i++) {
            testString = testString + "5";
        }

        // size will hold the optimal Vertical point size for the font
        Boolean up = null;
        int size = text.getHeight() / 4;
        Font font;
        int height = size;

        while (true) {
            font = new Font("Default", 0, size);
            int testHeight = getFontMetrics(font).getHeight();
            if (testHeight < height && up != Boolean.FALSE) {
                size++;
                up = Boolean.TRUE;
            } else if (testHeight > height && up != Boolean.TRUE) {
                size--;
                up = Boolean.FALSE;
            } else {
                break;
            }
        }
        // At this point, size holds the optimal Vertical font size

        // Now we will calculate the width of the sample string
        BufferedImage img = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
        FontMetrics fm = img.getGraphics().getFontMetrics(font);
        int width = fm.stringWidth(testString);

        // Using Martijn's answer, we calculate the optimal Horizontal font size
        int newFontSize = height * this.getWidth() / width;

        // The perfect font size will be the minimum between both optimal font sizes.
        // I have subtracted 2 from each font so that it is not too tight to the edges
        return Math.min(newFontSize - 2, size - 2);
    }
}
