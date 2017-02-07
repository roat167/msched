package edu.mum.swe.msched;

/**
 * Created by acer-usrpu on 2/6/2017.
 */
public class FacultyNotEnoughExecption extends RuntimeException {


    public FacultyNotEnoughExecption() {
    }

    public FacultyNotEnoughExecption(String message) {
        super(message);
    }

    public FacultyNotEnoughExecption(String message, Throwable cause) {
        super(message, cause);
    }

    public FacultyNotEnoughExecption(Throwable cause) {
        super(cause);
    }

    public FacultyNotEnoughExecption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
