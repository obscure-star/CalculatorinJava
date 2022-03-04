/**
 * the interface to define an operand in the
 * caclulator project.
 *
 * @summary operand interface.
 * @author Ifeanyi Ibeanusi
 *
 * Created at     : 2021-03-30 20:38:57 
 * Last modified  : 2021-03-30 20:39:28
 */


/**
 * the interface for an operand
 */
public interface IOperand {
    /**
     * get the type of the Operand int or double
     * 
     * @return int or double
     */
    public String getType();

    /**
     * set the type name to use for this item. double or int
     * 
     * @param typeName
     */
    public void setType(String typeName);

    /**
     * get the double value stored on this item
     * 
     * @return double
     */
    public double getDouble();

    /**
     * get the integer value for this item.
     * 
     * @return int
     */
    public int getInt();

    /**
     * set the value for the item
     * 
     * @param typeName int or double
     * @param valueD   the double value to store
     * @param valueI   the int value to store
     */
    public void setValue(String typeName, double valueD, int valueI);

    /**
     * check to see if the item has a value.
     */
    public boolean isSet();
}
