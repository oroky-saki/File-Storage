package com.vavilov.filestorage.exceptions;

public class UserIsNotExistsException extends RuntimeException {
    public UserIsNotExistsException(String message) {
        super(message);
    }
}
