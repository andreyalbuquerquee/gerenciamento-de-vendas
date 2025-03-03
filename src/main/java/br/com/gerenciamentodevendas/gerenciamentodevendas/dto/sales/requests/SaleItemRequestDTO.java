package br.com.gerenciamentodevendas.gerenciamentodevendas.dto.sales.requests;

import java.util.UUID;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record SaleItemRequestDTO(
    @NotNull(message = "O id do produto não pode estar vazio!")
    UUID productId,

    @Min(value = 1, message = "A quantidade deve ser pelo menos 1!")
    int quantity
) {}
