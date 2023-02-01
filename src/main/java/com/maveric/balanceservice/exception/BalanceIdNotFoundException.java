package com.maveric.balanceservice.exception;

public class BalanceIdNotFoundException extends RuntimeException{
    public BalanceIdNotFoundException(String message) {
        super(message);
    }
}