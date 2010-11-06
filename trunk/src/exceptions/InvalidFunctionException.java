package exceptions;


/**
 *
 * DOCUMENT ME!
 * 
 * @author Jaindson Valentim Santana
 */
public class InvalidFunctionException extends MSNLabException {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public InvalidFunctionException(String symbol, int line, int column){
	super("Unexpected symbol \"" + symbol + "\" found at line " + line + " and column " + column);
    }
    
}
