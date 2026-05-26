package com.salvadoreduardo.ecommerce.exception;

public class RuleException extends IllegalArgumentException {
    public RuleException(String message) {
        super(message);
    }
}