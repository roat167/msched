package edu.mum.swe.msched.exception;

public class PrerequisiteNotSatisfyException extends RuntimeException {
	private static final long serialVersionUID = 106118043335194459L;

	public PrerequisiteNotSatisfyException() {}

	public PrerequisiteNotSatisfyException(String message) {
		super(message);
	}

	public PrerequisiteNotSatisfyException(String message, Throwable cause) {
		super(message, cause);
	}

	public PrerequisiteNotSatisfyException(Throwable cause) {
		super(cause);
	}

	public PrerequisiteNotSatisfyException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
