package br.com.gerenciamentodevendas.gerenciamentodevendas.domain.exception;

public class BadRequestException extends ApplicationException {
    public BadRequestException(String message) {
        super(message, 400, "Bad Request");
    }
}
