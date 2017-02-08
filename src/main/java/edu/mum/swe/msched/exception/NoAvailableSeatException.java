package edu.mum.swe.msched.exception;

public class NoAvailableSeatException extends RuntimeException {
	private static final long serialVersionUID = -8348867767062159972L;

	public NoAvailableSeatException() {}

    public NoAvailableSeatException(String message) {
        super(message);
    }

    public NoAvailableSeatException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoAvailableSeatException(Throwable cause) {
        super(cause);
    }

    public NoAvailableSeatException	(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
