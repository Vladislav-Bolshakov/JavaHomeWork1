package com.pb.bolshakov.hw8;

public class WrongLoginException extends Exception {
    private String detail;

    public WrongLoginException() {
        this.detail = "Incorrect login";
    }

    public WrongLoginException(String message) {
        super(message);
        this.detail = message;
    }

    public String toString() {
        return "WrongLoginException: " + this.detail;
    }
}
