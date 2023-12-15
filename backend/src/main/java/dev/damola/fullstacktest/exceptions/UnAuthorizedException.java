package dev.damola.fullstacktest.exceptions;

public class UnAuthorizedException extends RuntimeException {


    public UnAuthorizedException(String msg) {
        super(msg);
    }
}
