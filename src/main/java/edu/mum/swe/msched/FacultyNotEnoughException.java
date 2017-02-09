package edu.mum.swe.msched;

/**
 * Created by acer-usrpu on 2/6/2017.
 */
public class FacultyNotEnoughException extends RuntimeException {


    public FacultyNotEnoughException() {
    }

    public FacultyNotEnoughException(String message) {
        super(message);
    }

    public FacultyNotEnoughException(String message, Throwable cause) {
        super(message, cause);
    }

    public FacultyNotEnoughException(Throwable cause) {
        super(cause);
    }

    public FacultyNotEnoughException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
