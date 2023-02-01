package com.maveric.balanceservice.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class AccountIdMismatchException extends Exception {
    public AccountIdMismatchException(String message) {
        super(message);

    }
}