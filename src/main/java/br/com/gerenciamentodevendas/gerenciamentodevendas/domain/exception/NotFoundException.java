package br.com.gerenciamentodevendas.gerenciamentodevendas.domain.exception;

public class NotFoundException extends ApplicationException {
    public NotFoundException(String message) {
        super(message, 404, "Not Found");
    }
}
