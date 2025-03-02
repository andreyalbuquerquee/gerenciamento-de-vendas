package br.com.gerenciamentodevendas.gerenciamentodevendas.dto.clients.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateClientRequestDTO(
    @NotBlank(message = "Nome não pode estar vazio!")    
    @Size(max = 150, min = 3, message = "Nome não pode ser maior que 150 caracteres!")
    String name,
    
    @NotBlank(message = "Email não pode estar vazio!")
    @Size(max = 150, min = 3, message = "Email não pode ser maior que 150 caracteres!")
    String email
) {}
