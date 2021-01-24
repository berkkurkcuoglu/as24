package com.example.as24.exceptions;

public class CsvParsingException extends RuntimeException {

    public CsvParsingException(String reason) {
        super(reason);
    }

    public CsvParsingException(String reason, Throwable cause) {
        super(reason, cause);
    }
}
