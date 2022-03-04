/**
 * the implementation of the answer to the problem.
 *
 * @summary short description for the file
 * @author Ifeanyi Ibeanusi
 *
 * Created at     : 2021-03-30 20:44:16 
 * Last modified  : 2021-03-30 20:44:37
 */




/**
 * 
 */
public class CalculatorAnswer implements ICalculatorAnswer {
    private String m_typeName;
    private IOperand m_answer;

    @Override
    public void setAnswer(String typeName, IOperand answer) {
        m_answer = answer;
        m_typeName = typeName;
    }

    @Override
    public IOperand getAnswer() {
        return m_answer;
    }

}
