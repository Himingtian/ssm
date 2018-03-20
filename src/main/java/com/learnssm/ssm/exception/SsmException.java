package com.learnssm.ssm.exception;

public class SsmException extends Exception {
    private String message;
    public SsmException(String message) {
       // super(message);
        this.message = message;
    }


    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
