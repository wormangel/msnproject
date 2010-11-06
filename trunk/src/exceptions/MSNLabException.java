
package exceptions;

/**
 * DOCUMENT ME!
 * 
 * @author Jaindson Valentim Santana
 */
public class MSNLabException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public MSNLabException(){
	
    }
    
    public MSNLabException(String message) {

	super(message);
    }

    public MSNLabException(String message, Throwable cause) {

	super(message, cause);
    }

    public MSNLabException(Throwable cause) {

	super(cause);
    }
}
