package exception;

public class OutOfLimitsException extends Exception {

	public OutOfLimitsException() {
		super();
	}

	@Override
	public String toString() {
		return "You have already added max no. of restaurants";
	}

}
