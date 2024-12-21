package Calculator;

/**
 * Calculator class
 * @author dhruvdh
 * @version 0.1
 */
public class Calculator {

    int lhs, rhs;

    /**
     * Constructor for Calulator
     * @param l Left hand side of the equation
     * @param r Right hand side of the equation
     */
    public Calculator(int l, int r) {
        lhs = l;
        rhs = r;
    }

    
    /** 
     * Add two numbers and return the result
     * @return int
     */
    public int add() {
        return lhs + rhs;
    }

    
    /** 
     * Subtract two numbers and return the result
     * @return int
     */
    public int subtract() {
        return lhs - rhs;
    }

    
    /** 
     * Multiply two numbers and return the result
     * @return int
     */
    public int multiply() {
        return lhs * rhs;
    }

    
    /** 
     * Divide two numbers and return the result, or throws an exception if the divisor is 0
     * @return int
     * @throws ArithmeticException
     */
    public int divide() throws ArithmeticException {
        if (rhs == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }

        return lhs / rhs;
    }
}