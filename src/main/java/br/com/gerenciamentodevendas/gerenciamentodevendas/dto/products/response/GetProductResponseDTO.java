package br.com.gerenciamentodevendas.gerenciamentodevendas.dto.products.response;

import java.math.BigDecimal;
import java.util.UUID;

public record GetProductResponseDTO(
    UUID id,
    String name,
    BigDecimal price
) {}
