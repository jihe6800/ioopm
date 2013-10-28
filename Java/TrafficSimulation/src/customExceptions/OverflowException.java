package customExceptions;  

public class OverflowException extends RuntimeException {
	
	public OverflowException() {
	    System.out.println("Lane full.");
	}

    }
