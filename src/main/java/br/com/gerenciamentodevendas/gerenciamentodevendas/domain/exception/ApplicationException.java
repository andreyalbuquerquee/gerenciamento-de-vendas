package br.com.gerenciamentodevendas.gerenciamentodevendas.domain.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApplicationException extends RuntimeException {
    private int statusCode;
    private String error;
    
    public ApplicationException(String message, int statusCode, String error) {
        super(message);
        this.statusCode = statusCode;
        this.error = error;
    }
}
