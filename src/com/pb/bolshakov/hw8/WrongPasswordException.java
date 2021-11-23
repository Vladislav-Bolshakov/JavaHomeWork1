package com.pb.bolshakov.hw8;


public class WrongPasswordException extends Exception {
    private String detail;

    public WrongPasswordException() {
        this.detail = "Incorrect password";
    }

    public WrongPasswordException(String message) {
        super(message);
        this.detail = message;
    }

    public String toString() {
        return "WrongPasswordException: " + this.detail;
    }
}
