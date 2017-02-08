package edu.mum.swe.msched.exception;

public class DuplicateRegisterCourseException extends RuntimeException {
	private static final long serialVersionUID = -5700810014975646772L;
	public DuplicateRegisterCourseException() {}

    public DuplicateRegisterCourseException(String message) {
        super(message);
    }

    public DuplicateRegisterCourseException(String message, Throwable cause) {
        super(message, cause);
    }

    public DuplicateRegisterCourseException(Throwable cause) {
        super(cause);
    }

    public DuplicateRegisterCourseException	(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
