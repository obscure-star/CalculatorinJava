/**
 * the interface for the calculator operations.
 *
 * @summary short description for the file
 * @author Ifeanyi Ibeanusi
 *
 * Created at     : 2021-03-30 20:40:07 
 * Last modified  : 2021-03-30 20:40:23
 */


/**
 * the interface for operations
 */
public interface IOperation {
    /**
     * get the operation that this object holds
     * 
     * @return
     */
    public String getOperation();

    /**
     * set the operation string to use for this operation
     * 
     * @param opName
     */
    public void setOperation(String opName);

    /**
     * check to see if the object is set.
     * 
     * @return
     */
    public boolean isSet();
}
