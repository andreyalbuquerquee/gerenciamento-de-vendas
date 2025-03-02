package br.com.gerenciamentodevendas.gerenciamentodevendas.dto.products.response;

import java.math.BigDecimal;
import java.util.UUID;

public record UpdateProductResponseDTO(
    UUID id,
    String name,
    BigDecimal price
) {}
