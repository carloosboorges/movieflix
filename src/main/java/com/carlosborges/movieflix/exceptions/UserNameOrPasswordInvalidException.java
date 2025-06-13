package com.carlosborges.movieflix.exceptions;

public class UserNameOrPasswordInvalidException extends RuntimeException {

    public UserNameOrPasswordInvalidException(String message) {
        super(message);
    }
}
