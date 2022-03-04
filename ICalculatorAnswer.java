/**
 * An interface to build for supplying answers
 * for the calculator
 *
 * @summary calculator answer
 * @author Ifeanyi Ibeanusi
 *
 * Created at     : 2021-03-30 20:37:43 
 * Last modified  : 2021-03-30 20:38:26
 */



/**
 * a simple answer for a math problem interface
 */
public interface ICalculatorAnswer {
    /**
     * set the type of the answer to the problem
     * 
     * @param typeName int or double
     * @param answer   the result
     */
    public void setAnswer(String typeName, IOperand answer);

    public IOperand getAnswer();
}
