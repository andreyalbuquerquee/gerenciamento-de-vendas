package br.com.gerenciamentodevendas.gerenciamentodevendas.dto.sales.responses;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record GetSaleResponseDTO(
    UUID id,
    UUID clientId,
    List<SaleItemResponseDTO> items,
    BigDecimal totalPrice,
    LocalDateTime createdAt
) {}
