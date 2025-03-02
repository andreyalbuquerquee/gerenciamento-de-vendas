package br.com.gerenciamentodevendas.gerenciamentodevendas.exception;

import br.com.gerenciamentodevendas.gerenciamentodevendas.domain.exception.BadRequestException;
import br.com.gerenciamentodevendas.gerenciamentodevendas.domain.exception.NotFoundException;
import br.com.gerenciamentodevendas.gerenciamentodevendas.dto.exception.ExceptionResponseDTO;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionResponseDTO> handleNotFoundException(NotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ExceptionResponseDTO(
            ex.getStatusCode(), 
            ex.getError(), 
            ex.getMessage()));
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ExceptionResponseDTO> handleBadRequestException(BadRequestException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionResponseDTO(
            ex.getStatusCode(), 
            ex.getError(), 
            ex.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponseDTO> handleUnknowException(Exception ex) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new ExceptionResponseDTO(
            HttpStatus.FORBIDDEN.value(), 
            "Forbidden", 
            "Um erro desconhecido ocorreu!"));
    }
}
