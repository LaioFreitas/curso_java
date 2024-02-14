package model.exception;

public class InsufficientFundException extends Exception {
    private static final long serialVersionUID = 1L;

    public InsufficientFundException(String msg) {
        super(msg);
    }
}
