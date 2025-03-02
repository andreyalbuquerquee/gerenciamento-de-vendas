package br.com.gerenciamentodevendas.gerenciamentodevendas.dto.clients.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;

public record CreateClientRequestDTO(
    @NotEmpty(message = "Nome não pode estar vazio!")    
    @Max(value = 150, message = "Nome não pode ser maior que 150 caracteres!")
    String name,
    @NotEmpty(message = "Email não pode estar vazio!")
    @Max(value = 150, message = "Email não pode ser maior que 150 caracteres!")
    String email
) {}
