package br.com.gerenciamentodevendas.gerenciamentodevendas.dto.clients.response;

import java.util.UUID;

public record CreateClientResponseDTO(
    UUID id,
    String name,
    String email
) {}
