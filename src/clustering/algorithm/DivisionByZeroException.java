package clustering.algorithm;

/**
 * DivisionByZeroException
 */
public class DivisionByZeroException extends Exception {
    private static final long serialVersionUID = 1L;
    private String divisionByZeroString = "";

    public DivisionByZeroException(String divisionByZeroString) {
        super("DivisionByZeroException");
        this.divisionByZeroString = divisionByZeroString;
    }

    public String toString() {
        return "DivisionByZeroException Found on " + divisionByZeroString;
    }
    
}