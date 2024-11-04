package io.nnc.bookinfoservice.exception;

public class ConcurrentProcessingException extends RuntimeException{
    public ConcurrentProcessingException(String msg) {
        super(msg);
    }
}
