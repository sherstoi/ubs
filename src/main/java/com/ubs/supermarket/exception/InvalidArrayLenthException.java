package com.ubs.supermarket.exception;

/**
 * This class represent exception which
 * thrown when there are too much spaces
 * in field.
 * @Author Iurii
 * @Version 1.0
 */
public class InvalidArrayLenthException extends RuntimeException {

    public InvalidArrayLenthException(String message) {
        super(message);
    }
}
