package br.com.gerenciamentodevendas.gerenciamentodevendas.dto.clients.response;

import java.util.UUID;

public record UpdateClientResponseDTO(
    UUID id,
    String name,
    String email
) {}
