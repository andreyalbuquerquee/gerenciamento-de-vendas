package br.com.gerenciamentodevendas.gerenciamentodevendas.dto.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ExceptionResponseDTO {
    private Integer statusCode;
    private String error;
    private String errorMessage;
}
