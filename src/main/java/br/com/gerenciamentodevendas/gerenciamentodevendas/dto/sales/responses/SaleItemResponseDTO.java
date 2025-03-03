package br.com.gerenciamentodevendas.gerenciamentodevendas.dto.sales.responses;

import java.math.BigDecimal;
import java.util.UUID;

public record SaleItemResponseDTO(
    UUID productId,
    int quantity,
    BigDecimal unitPrice,
    BigDecimal subTotal
) {}
